// An Eulerian Path is a path in graph that visits every edge exactly once and it starts and ends up at different indexes. An Eulerian Circuit is an Eulerian Path which starts and ends on the same vertex. Given an undirected acyclic graph with V nodes, and E edges, with adjacency list adj, return 2 if the graph contains an eulerian circuit, else if the graph contains an eulerian path, return 1, otherwise, return 0.
//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        
        while (tc-- > 0) {
            int V = scanner.nextInt();
            int E = scanner.nextInt();
            
            List<Integer>[] adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < E; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            
            // String x=scanner.nextLine();
            // scanner.nextLine();
            
            Solution obj = new Solution();
            int ans = obj.isEulerCircuit(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution{
    public int isEulerCircuit(int V, List<Integer>[] adj) 
    {
        // code here
        int e=0,od=0;
        for(int i=0;i<V;i++){
            if(adj[i].size()%2==0){
                e++;
            }else{
                od++;
            }
        }
        if(e==V)
        return 2;
        if(od==2){
            return 1;
            
        }
        return 0;
    }
}