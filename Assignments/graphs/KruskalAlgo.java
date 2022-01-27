package graphs;

import java.util.*;

class Nodes {
    private int u;
    private int v;
    private int weight;

    Nodes(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.weight = w;
    }

    Nodes() {
    }

    int getU() {
        return u;
    }

    int getV() {
        return v;
    }

    int getWeight() {
        return weight;
    }

}

class SortComparator implements Comparator<Nodes> {
    @Override
    public int compare(Nodes node1, Nodes node2) {
        if (node1.getWeight() < node2.getWeight()) {
            return -1;
        }
        if (node1.getWeight() > node2.getWeight()) {
            return 1;
        }
        return 0;
    }
}

class KruskalAlgo {
    private int findParent(int node, int parent[]) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findParent(parent[node], parent);
    }

    private void union(int u, int v, int parent[], int rank[]) {
        u = findParent(u, parent);
        v = findParent(v, parent);

        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[v] < rank[u]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public void KruskalAlgo(ArrayList<Nodes> adj, int N) {
        Collections.sort(adj, new SortComparator());
        int parent[] = new int[N];
        int rank[] = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int costMst = 0;
        ArrayList<Nodes> mst = new ArrayList<>();
        for (Nodes it : adj) {
            if (findParent(it.getU(), parent) != findParent(it.getV(), parent)) {
                costMst += it.getWeight();
                mst.add(it);
                union(it.getU(), it.getV(), parent, rank);
            }
        }
        System.out.println(costMst);
        for (Nodes it : mst) {
            System.out.println(it.getU() + " - " + it.getV());
        }
    }

    public static void main(String args[]) {
        int n = 5;
        ArrayList<Nodes> adj = new ArrayList<>();
        adj.add(new Nodes(0, 1, 2));
        adj.add(new Nodes(0, 3, 6));
        adj.add(new Nodes(1, 3, 8));
        adj.add(new Nodes(1, 2, 3));
        adj.add(new Nodes(1, 4, 5));
        adj.add(new Nodes(2, 4, 7));

        KruskalAlgo ka = new KruskalAlgo();
        ka.KruskalAlgo(adj, n);
    }
}