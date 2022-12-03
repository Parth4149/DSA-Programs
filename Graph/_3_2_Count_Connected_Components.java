package Graph;

import java.util.ArrayList;

// Count connected components in an undirected Graph using DFS
class graph_dfs {
    public int V; // No. of vertices
    private ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private boolean[] visited;

    public graph_dfs(int v) {// constructor
        V = v;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean[V];
    }

    public int DFS(int v) {
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                DFSRec(i);
                count++;
            }
        }
        return count;
    }

    private void DFSRec(int s) {
        visited[s] = true;
//        System.out.print(s + " ");
        for (int i : adj.get(s)) {
            if (!visited[i]) {
                DFSRec(i);
            }
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {// time comp : O(V+E)
        graph_dfs g = new graph_dfs(8);

        g.addEdge(0, 1);// first Graph
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        g.addEdge(4, 5);// Second Graph
        g.addEdge(4, 6);
        g.addEdge(5, 7);

        int ans = g.DFS(g.V);
        System.out.println(ans);
    }
}



