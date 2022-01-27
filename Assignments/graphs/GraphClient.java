package graphs;

import java.util.Arrays;

public class GraphClient {
    public static void main(String[] args) {
        Graph g = new Graph(8);

        g.addEdge(0, 1, false);
        g.addEdge(0, 2, false);
        g.addEdge(2, 3, false);
        g.addEdge(2, 4, false);
        g.addEdge(3, 1, false);
        g.addEdge(5, 3, false);
        g.addEdge(5, 6, false);
        g.addEdge(4, 6, false);
        g.addEdge(6, 7, false);
        g.addEdge(7, 4, false);
//        g.display();
//        g.bfsTraversal(1);
//        g.dfsTraversal(1);
//        System.out.println(g.hasCycleDFS());
//        System.out.println(g.isBipartiteDFS());
//        g.topologicalSorting();
//        System.out.println();
//        int[] ans = g.topologicalSort();
//        System.out.println(Arrays.toString(ans));
        g.shortestPath(0);
    }
}
