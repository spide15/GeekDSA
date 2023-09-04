// Given a matrix mat of size N x M where every element is either 'O' or 'X'. Replace all 'O' with 'X' that are surrounded by 'X'.

// A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        // for border case
        for(int i=0;i<n;i++){
            // 1 col
            if(a[i][0]=='O'){
                dfs(a,i,0,'O','-',n,m);
            }
             // last col
            if(a[i][m-1]=='O'){
                dfs(a,i,m-1,'O','-',n,m);
            }
        }
        
       
        
        for(int i=0;i<m;i++){
            // first row
            if(a[0][i]=='O'){
                dfs(a,0,i,'O','-',n,m);
            }
                        // last row
            if(a[n-1][i]=='O'){
                dfs(a,n-1,i,'O','-',n,m);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='O'){
                    a[i][j]='X';
                }
            }
        }
        
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='-'){
                    a[i][j]='O';
                }
            }
        }
        
        return a;
        
    }
    static void dfs(char[][] a,int x,int y,char prev,char newC,int N,int M){
        if(x<0 || x>=N || y<0 || y>=M){
            return;
        }
        
        if(a[x][y]!=prev){
            return;
        }
        a[x][y]=newC;
        dfs(a,x,y+1,prev,newC,N,M);
        dfs(a,x+1,y,prev,newC,N,M);
        dfs(a,x,y-1,prev,newC,N,M);
        dfs(a,x-1,y,prev,newC,N,M);
        
    } 
    
    
    
}