// Given a matrix of order nxm, composed of only 0's and 1's, find the number of 1's in the matrix that are surrounded by an even number (>0) of 0's. The surrounding of a cell in the matrix is defined as the elements above, below, on left, on right as well as the 4 diagonal elements around the cell of the matrix. Hence, the surrounding of any matrix elements is composed of 8 elements. Find the number of such 1's
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        
       int ans = 0;
        
        // code here
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 1){
                    int zc = zcf(matrix,i,j);
                    //System.out.println(zc);
                    if(zc > 0 && zc % 2 == 0) ans++;
                }
            }
        }
        
        return ans;
    }
    
    public int zcf(int[][] matrix, int i, int j){
        int n = matrix.length;
        int m = matrix[i].length;
        
        int[] ii = new int[]{-1,-1,-1, 0, 1, 1, 1, 0};
        int[] ji = new int[]{-1, 0, 1, 1, 1, 0,-1,-1};

        int zc = 0;
        for(int k = 0;k<8;k++){
            if(i-ii[k]>=0 && i-ii[k]<n && j-ji[k]>=0 && j-ji[k]<m && matrix[i-ii[k]][j-ji[k]] == 0) zc++; 
        }
        
        return zc;
    }

}