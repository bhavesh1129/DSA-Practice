package graphs;

import java.util.*;

public class Graph {
    int V;
    Map<Integer, List<Integer>> adjList;

    public Graph(int V) {
        this.V = V;
        this.adjList = new HashMap<>();
    }

    public void addEdge(int u, int v, boolean isBidir) {
        List<Integer> neighbourU = adjList.getOrDefault(u, new ArrayList<>());
        neighbourU.add(v);
        adjList.put(u, neighbourU);

        if (isBidir) {
            List<Integer> neighbourV = adjList.getOrDefault(v, new ArrayList<>());
            neighbourV.add(u);
            adjList.put(v, neighbourV);
        }
    }

    public void display() {
        for (int vertex : adjList.keySet()) {
            System.out.println(vertex + "->" + adjList.get(vertex));
        }
    }

    public void bfsTraversal(int src) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(src);
        vis.add(src);
        while (!q.isEmpty()) {
            int front = q.poll();
            System.out.print(front + " ");
            List<Integer> neighbourList = adjList.getOrDefault(front, new ArrayList<>());
            for (int neighbour : neighbourList) {
                if (!vis.contains(neighbour)) {
                    q.add(neighbour);
                    vis.add(neighbour);
                }
            }
        }
    }

    public void dfsTraversal(int src) {
        Set<Integer> vis = new HashSet<>();
        dfs(src, vis);
    }

    private void dfs(int src, Set<Integer> vis) {
        System.out.print(src + " ");
        vis.add(src);
        List<Integer> neighbours = adjList.getOrDefault(src, new ArrayList<>());
        for (int neighbour : neighbours) {
            if (!vis.contains(neighbour)) {
                dfs(neighbour, vis);
            }
        }
    }

    public class Node {
        int val;
        int prev;

        public Node(int val, int prev) {
            this.val = val;
            this.prev = prev;
        }
    }

    public boolean hasCycleBFS() {
        Set<Integer> vis = new HashSet<>();
        return isCycleBFS(V, vis);
    }

    private boolean isCycleBFS(int V, Set<Integer> vis) {
        for (int i = 1; i <= V; i++) {
            if (!vis.contains(i)) {
                if (checkCycle(i, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCycle(int i, Set<Integer> vis) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, -1));
        vis.add(i);

        while (!queue.isEmpty()) {
            Node front = queue.poll();
            int node = front.val;
            int prev = front.prev;

            List<Integer> neighbours = adjList.getOrDefault(node, new ArrayList<>());
            for (int neighbour : neighbours) {
                if (!vis.contains(neighbour)) {
                    queue.add(new Node(neighbour, node));
                    vis.add(neighbour);
                } else if (prev != neighbour) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasCycleDFS() {
        Set<Integer> vis = new HashSet<>();
        for (int i = 1; i <= V; i++) {
            if (!vis.contains(i)) {
                if (checkCycle(i, -1, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCycle(int node, int prev, Set<Integer> vis) {
        vis.contains(node);
        List<Integer> neighbours = adjList.getOrDefault(node, new ArrayList<>());
        for (int neighbour : neighbours) {
            if (!vis.contains(neighbour)) {
                if (checkCycle(neighbour, node, vis) == true) {
                    return true;
                } else if (neighbour != prev) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBipartiteBFS() {
        int[] colors = new int[adjList.size()];
        Arrays.fill(colors, -1);
        for (int i = 1; i <= V; i++) {
            if (colors[i] == -1 && !checkForBFS(i, colors)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkForBFS(int node, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colors[node] = 1;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            List<Integer> neighbours = adjList.getOrDefault(node, new ArrayList<>());
            for (int neighbour : neighbours) {
                if (colors[neighbour] == -1) {
                    colors[neighbour] = 1 - colors[node];
                    queue.add(neighbour);
                } else if (colors[neighbour] != colors[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartiteDFS() {
        int[] colors = new int[adjList.size()];
        Arrays.fill(colors, -1);
        for (int i = 1; i <= V; i++) {
            if (colors[i] == -1 && !checkForDFS(i, colors)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkForDFS(int node, int[] colors) {
        if (colors[node] == -1) {
            colors[node] = 1;
        }
        List<Integer> neighbours = adjList.getOrDefault(node, new ArrayList<>());
        for (int i : neighbours) {
            if (colors[i] == -1) {
                colors[i] = 1 - colors[node];
                if (!checkForDFS(i, colors)) {
                    return false;
                } else if (colors[i] == colors[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] indegree() {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            List<Integer> neighbours = adjList.getOrDefault(i, new ArrayList<>());
            for (int neighbour : neighbours) {
                indegree[neighbour]++;
            }
        }
        return indegree;
    }

    /* Topological Sort using BFS(Kahn's Algo) */
    public void topologicalSorting() {
        int[] indegree = indegree();
        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                bfs.add(i);
            }
        }
        while (!bfs.isEmpty()) {
            int front = bfs.poll();
            System.out.print(front + " ");

            List<Integer> neighbours = adjList.getOrDefault(front, new ArrayList<>());
            for (int neighbour : neighbours) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    bfs.add(neighbour);
                }
            }
        }
    }

    /* Topological Sort using DFS */
    private void findTopoSort(int node, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        List<Integer> neighbours = adjList.getOrDefault(node, new ArrayList<>());
        for (int i : neighbours) {
            if (vis[i] == 0) {
                findTopoSort(i, vis, st);
            }
        }
        st.push(node);
    }

    public int[] topologicalSort() {
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                findTopoSort(i, vis, st);
            }
        }

        int[] topo = new int[V];
        int ind = 0;
        while (!st.isEmpty()) {
            topo[ind++] = st.pop();
        }
        return topo;
    }

    public void shortestPath(int src) {
        int[] dis = new int[V];
        for (int i = 0; i < V; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> q = new LinkedList<>();
        dis[src] = 0;
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.poll();
            List<Integer> neighbours = adjList.getOrDefault(node, new ArrayList<>());
            for (int i : neighbours) {
                if (dis[node] + 1 < dis[i]) {
                    dis[i] = dis[node] + 1;
                    q.add(i);
                }
            }
        }
        System.out.println(Arrays.toString(dis));
    }
}