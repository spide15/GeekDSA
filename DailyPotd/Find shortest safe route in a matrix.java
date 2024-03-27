// Given a matrix mat[][] with r rows and c columns, where some cells are landmines (marked as 0) and others are safe to traverse. Your task is to find the shortest safe route from any cell in the leftmost column to any cell in the rightmost column of the mat. You cannot move diagonally, and you must avoid both the landmines and their adjacent cells (up, down, left, right), as they are also unsafe.
//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class IntArray {
        public static int[] input(BufferedReader br, int n) throws IOException {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
    
            return a;
        }
    
        public static void print(int[] a) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    
        public static void print(ArrayList<Integer> a) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
    
    class IntMatrix {
        public static int[][] input(BufferedReader br, int n, int m) throws IOException {
            int[][] mat = new int[n][];
    
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().trim().split(" ");
                mat[i] = new int[s.length];
                for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
            }
    
            return mat;
        }
    
        public static void print(int[][] m) {
            for (var a : m) {
                for (int e : a) System.out.print(e + " ");
                System.out.println();
            }
        }
    
        public static void print(ArrayList<ArrayList<Integer>> m) {
            for (var a : m) {
                for (int e : a) System.out.print(e + " ");
                System.out.println();
            }
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
    
                int[] a = IntArray.input(br, 2);
    
                int[][] mat = IntMatrix.input(br, a[0], a[1]);
    
                Solution obj = new Solution();
                int res = obj.findShortestPath(mat);
    
                System.out.println(res);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    class Solution {
        static class Node{
            int dist;
            int x;
            int y;
            
            Node(int dist,int x,int y){
                this.dist=dist;
                this.x=x;
                this.y=y;
            }
        }
        public static int findShortestPath(int[][] mat) {
            // code here
            int m=mat.length;
            int n=mat[0].length;
            int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
            boolean[][] visited=new boolean[m][n];
            PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->(a.dist-b.dist));
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j]==0){
                        visited[i][j]=true;
                        for(int[] dir:directions){
                            int nx=i+dir[0];
                            int ny=j+dir[1];
                            if(nx>=0 && ny>=0 && nx<m && ny<n && mat[nx][ny]==1){
                                mat[nx][ny]=-1;
                            }
                        }
                    }
                }
            }
            for(int i=0;i<m;i++){
                if(mat[i][0]==1){
                    pq.add(new Node(1,i,0));
                    visited[i][0]=true;
                }
            }
            while(!pq.isEmpty()){
                Node curr=pq.poll();
                if(curr.y==n-1){
                    return curr.dist;
                }
                for(int[] dir:directions){
                    int nx=curr.x+dir[0];
                    int ny=curr.y+dir[1];
                    if(nx>=0 && ny>=0  && nx<m && ny<n && mat[nx][ny]==1 && !visited[nx][ny]){
                        pq.add(new Node(curr.dist+1,nx,ny));
                        visited[nx][ny]=true;
                    }
                }
            }
            return -1;
        }
    }
    