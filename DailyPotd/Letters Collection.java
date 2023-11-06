// The Postmaster wants to write a program to answer the queries regarding letter collection in a city. A city is represented as a matrix mat of size n*m. Each cell represents a house and contains letters which are denoted by a number in the cell. The program should answer q queries which are of following types:
// 1 i j : To sum all the letters which are at a 1-hop distance from the cell (i,j) in any direction
// 2 i j : To sum all the letters which are at a 2-hop distance from the cell (i,j) in any direction 
// The queries are given in a 2D matrix queries[][].
// In one hop distance postmaster can go to any of [(i-1,j-1), (i-1,j), (i-1,j+1), (i,j-1), (i,j+1), (i+1,j-1), (i+1,j), (i+1,j+1)] from (i,j). 
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
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int mat[][] = new int[n][m];
            for(int i = 0;i < n;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    mat[i][j] = Integer.parseInt(a[j]);
            }
            int q = Integer.parseInt(in.readLine());
            int queries[][] = new int[q][3];
            for(int i = 0;i < q;i++){
                String a1[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < 3;j++)
                    queries[i][j] = Integer.parseInt(a1[j]);
            }
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.matrixSum(n, m, mat, q, queries);
            for(int i = 0;i < q;i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][])
    {
        // code here
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<q;i++){
            int hop=queries[i][0];
            int r=queries[i][1];
            int s=queries[i][2];
            
            if(hop==1){
                int dx[]={-1,-1,-1,0,0,1,1,1};
                int dy[]={-1,0,1,-1,1,-1,0,1};
                int sum=0;
                for(int j=0;j<8;j++){
                    int p=r+dx[j];
                    int q1=s+dy[j];
                    if(p>=0 && p<n && q1>=0 && q1<m){
                        sum+=mat[p][q1];
                    }
                }
                ans.add(sum);
            }else{
                 int dx[] = {-2, -2, 2, 2, -2, 2, 0, 0, -2, -2, 2, 2, -1, 1, -1, 1};
                int dy[] = {-2, 2, -2, 2, 0, 0, -2, 2, -1, 1, -1, 1, -2, -2, 2, 2};
                int sum=0;
                   for(int j=0;j<16;j++){
                    int p=r+dx[j];
                    int q1=s+dy[j];
                    if(p>=0&&p<n&&q1>=0&&q1<m)
                    sum+=mat[p][q1];
                }
                ans.add(sum);
            }
        }
        return ans;
    }
}