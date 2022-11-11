package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
 * BFS is slower than DFS
 * BFS is more suitable for searching vertices which are closer to the given source
 * BFS considers all neighbors first and therefore not suitable for decision-making trees used in games or puzzles
 * Time complexity : O(V+E),   adjacency list :O(V^2) ,  where V stands for vertices and E stands for edges
 * here, siblings are visited before the children
 * Applications : Bipartite graph, Shortest path etc.
 * DFS require more memory
 * */

class GraphBFS {
    private int V; // No. of vertices
    private ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private boolean[] visited;

    public GraphBFS(int v) {// constructor
        V = v;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        visited = new boolean[V];
    }

    public void BFSDis(int v) { // BFS of disconnected graph
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {// visited[i]==false
                BFS(i);
            }
        }
    }

    private void BFS(int s) {
        // Create a Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            // Deque a vertex from queue and print it
            int u = q.poll();// Retrieve and Remove the head of Queue, or return null if Queue is empty
            System.out.print(u + " ");

            // Get all adjacent vertices of the de-queued vertex u  (s)
            // If a adjacent has not been visited, then mark it visited and enqueue it
            for (int i : adj.get(u)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    private void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) { // time comp : O(V+E)
        GraphBFS g = new GraphBFS(8);

        g.addEdge(0, 1);// 1st Graph
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        g.addEdge(4, 5);// 2nd Graph
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.BFSDis(g.V);
    }
}