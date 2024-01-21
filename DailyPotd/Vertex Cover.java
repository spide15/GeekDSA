// Vertex cover of an undirected graph is a list of vertices such that every vertex not in the vertex cover shares their every edge with the vertices in the vertex cover. In other words, for every edge in the graph, atleast one of the endpoints of the graph should belong to the vertex cover. You will be given an undirected graph G, and your task is to determine the smallest possible size of a vertex cover.
//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    
    class IntMatrix
    {
        public static int[][] input(BufferedReader br, int n, int m) throws IOException
        {
            int[][] mat = new int[n][];
            
            for(int i = 0; i < n; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                mat[i] = new int[s.length];
                for(int j = 0; j < s.length; j++)
                    mat[i][j] = Integer.parseInt(s[j]);
            }
            
            return mat;
        }
        
        public static void print(int[][] m)
        {
            for(var a : m)
            {
                for(int e : a)
                    System.out.print(e + " ");
                System.out.println();
            }
        }
        
        public static void print(ArrayList<ArrayList<Integer>> m)
        {
            for(var a : m)
            {
                for(int e : a)
                    System.out.print(e + " ");
                System.out.println();
            }
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                
                int n; 
                n = Integer.parseInt(br.readLine());
                
                
                int m; 
                m = Integer.parseInt(br.readLine());
                
                
                int[][] edges = IntMatrix.input(br, m, 2);
                
                Solution obj = new Solution();
                int res = obj.vertexCover(n, m, edges);
                
                System.out.println(res);
                
            }
        }
    }
    
    // } Driver Code Ends
    
    
    class Solution {
        public static int vertexCover(int n, int m, int[][] edges) {
            // code here
            int ans=Integer.MAX_VALUE;
            for(int i=0;i<(1<<n);i++){
                int totalEdge=m;
                
                
                for(int edg=0;edg<m;edg++){
                    int u=edges[edg][0]-1;
                    int v=edges[edg][1]-1;
                    if(((i>>u)&1)==1 || ((i>>v) &1)==1){
                        totalEdge--;
                    }
                }
                
                if(totalEdge==0){
                    int vertices=findSetBits(i);
                    ans=Math.min(ans,vertices);
                }
            }
            return ans;
        }
        public static int findSetBits(int n){
            int result=0;
            while(n!=0){
                n=n&(n-1);
                result++;
                
            }
            return result;
        }
    }
            
    