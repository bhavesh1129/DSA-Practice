package graphs;

import java.util.*;

class Node implements Comparator<Node> {
    private int v;//value of node
    private int weight;//weight on edges

    Node(int v, int w) {
        this.v = v;
        this.weight = w;
    }

    Node() {
    }

    int getV() {
        return v;
    }

    int getWeight() {
        return weight;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.weight < node2.weight) {
            return -1;
        }
        if (node1.weight > node2.weight) {
            return 1;
        }
        return 0;
    }
}

public class DjistraAlgo {
    public static void main(String args[]) {
        int n = 5;
        ArrayList<List<Node>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Node>());
        }

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(1, 4));

        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));

        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));

        shortestPath(0, adj, n);
    }

    private static void shortestPath(int s, ArrayList<List<Node>> adj, int N) {
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
        pq.add(new Node(s, 0));
        while (pq.size() > 0) {
            Node node = pq.poll();
            for (Node i : adj.get(node.getV())) {
                if (dist[node.getV()] + i.getWeight() < dist[i.getV()]) {
                    dist[i.getV()] = dist[node.getV()] + i.getWeight();
                    pq.add(new Node(i.getV(), dist[i.getV()]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
