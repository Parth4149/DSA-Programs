package Graph;

import java.util.ArrayList;

// Detect Cycle in Undirected Graph
class UndirectedGraph {
    public static void main(String[] args) {
        UndirectedGraph g = new UndirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        // g.addEdge(2,3);
        boolean ans = g.DFS(g.V);
        System.out.println(ans);
    }

    int V;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    boolean[] visited;

    UndirectedGraph(int v) {// Constructor
        V = v;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        visited = new boolean[V];// initialize , by default all elements are false(0)
    }

    boolean DFS(int v) {
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {//  DFSRec(u, s)
                if (DFSRec(i, -1))
                    return true;
            }

        }
        return false;
    }

    boolean DFSRec(int s, int parent) {
        visited[s] = true;
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                if (DFSRec(u, s))      //DFSRec(u, s) = true
                    return true;
            } else if (u != parent)
                return true;
        }
        return false;
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
