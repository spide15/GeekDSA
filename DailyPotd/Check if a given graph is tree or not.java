// You are given an undirected graph of N nodes (numbered from 0 to N-1) and M edges. Return 1 if the graph is a tree, else return 0.

// Note: The input graph can have self-loops and multiple edges.
//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    public class GFG {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t=scanner.nextInt();
            while(t-- > 0)
            {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
        
                ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
                for (int i = 0; i < m; i++) {
                    int u = scanner.nextInt();
                    int v = scanner.nextInt();
                    ArrayList<Integer> edge = new ArrayList<>();
                    edge.add(u);
                    edge.add(v);
                    edges.add(edge);
                }
        
                Solution solution = new Solution();
                boolean result = solution.isTree(n, m, edges);
        
                if (result==true) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
    // } Driver Code Ends
    
    
    //User function Template for Java
    class Solution {
        public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
        {
            // code here
            if(m!=n-1)
            return false;
            
            int[] parent=new int[n];
            Arrays.fill(parent,-1);
            
            for(ArrayList<Integer> adj:edges){
                int u=findParent(adj.get(0),parent);
                int v=findParent(adj.get(1),parent);
                
                if(u==v)
                return false;
                
                parent[u]=v;
            }
            return true;
        }
        private static int findParent(int i,int[] parent){
            while(parent[i]!=-1){
                i=parent[i];
            }
            return i;
        }
    }
    
    