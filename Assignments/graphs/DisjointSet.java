package graphs;

import java.util.Scanner;

public class DisjointSet {
    static int N;
    static int[] parent = new int[N];
    static int[] rank = new int[N];

    public DisjointSet(int N) {
        this.N = N;
    }

    public void makeSet() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    public static void union(int u, int v) {
        u = findParent(u);
        v = findParent(v);

        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[u] > rank[v]) {
            parent[v] = u;
        } else {
            parent[u] = v;
            rank[u]++;
        }
    }

    public static void main(String[] args) {
        int N = 5;
        Scanner sc = new Scanner(System.in);
        while (N-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            union(u, v);

            if (findParent(u) == findParent(v)) {
                System.out.println("Same component!");
            } else {
                System.out.println("Different Components!");
            }
        }
    }
}
