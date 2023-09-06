// Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
// A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean[] vis=new boolean[V];
        int motherVertex=-1;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adj,i,vis);
                motherVertex=i;
            }
        }
        Arrays.fill(vis,false);
        dfs(adj,motherVertex,vis);
        
        for(boolean val:vis){
            if(!val){
                return -1;
            }
        }
        return motherVertex;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int v,boolean[] vis){
        vis[v]=true;
        for(int neigh:adj.get(v)){
            if(!vis[neigh]){
                dfs(adj,neigh,vis);
            }
        }
    }
}