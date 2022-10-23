package Program_and_Project;
import java.util.ArrayList;
/*
* DFS is more suitable when there are solutions away from source
* DFS is more suitable for game or puzzle problems, we make a decision ,then explore all paths through this decision
* Time complexity : O(V+E) , adjacency list : O(V^2),
* here, children are visited before the siblings
* Applications : Acyclic graph and topological order etc.
* DFS require less memory
* */
class GraphDFS {
    private int V; // No. of vertices
    private ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    private boolean[] visited;
    public static void main(String[] args) {// time comp : O(V+E)
        GraphDFS g=new GraphDFS(8);

        g.addEdge(0, 1);// first Graph
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        g.addEdge(4,5);// Second Graph
        g.addEdge(4,6);
        g.addEdge(5,7);
        g.DFS(g.V);
    }

    public GraphDFS(int v) {// constructor
        V=v;
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        visited=new boolean[V];
    }
    public void DFS(int v) {
        for(int i=0; i<v; i++){
            if(!visited[i]){
                DFSRec(i);
            }
        }
    }
    private void DFSRec(int s) {
        visited[s]=true;
        System.out.print(s+" ");
        for(int i:adj.get(s)){
            if(!visited[i]){
                DFSRec(i);
            }
        }
    }
    public void addEdge(int u,int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}



