package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Count connected components in an undirected Graph // Number of islands  in a Graph
class Graph {
    private int V; // No. of vertices
    private ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private boolean[] visited;

    public Graph(int v) {
        this.V = v;
        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public int countConnectedComponent(int v) {
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                BFS(i);
                count++;
            }
        }
        return count;
    }

    public void BFS(int s) {
        // Create a Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // mark current node as visited and enqueue it
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()) {
            // deque a vertex from a queue
            int u = q.poll();// Retrieve and Remove the head of Queue, or return null if Queue is empty

            // Get all adjacent vertices of the de-queued vertex u  (s)
            // If a adjacent has not been visited, then mark it visited and enqueue it
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);

        g.addEdge(0, 1);// 1st Graph
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        g.addEdge(4, 5);// 2nd Graph
        g.addEdge(4, 6);
        g.addEdge(5, 7);

        int ans = g.countConnectedComponent(g.V); // no. of islands
        System.out.println(ans);
    }
}
