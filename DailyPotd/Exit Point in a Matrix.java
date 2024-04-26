// Given a matrix of size n x m with 0’s and 1’s, you enter the matrix at cell (0,0) in left to right direction. Whenever you encounter a 0 you retain it in the same direction, else if you encounter a 1 you have to change the direction to the right of the current direction and change that 1 value to 0, you have to find out from which index you will leave the matrix at the end.
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        int dir=1;
        int i=0,j=0;
        int[] ans=new int[2];
        while(i>=0 && i<n && j>=0 && j<m){
            if(matrix[i][j]==1){
                matrix[i][j]=0;
                dir=(dir%4)+1;
            }
            if(dir==1){
                j++;
            }
            else if(dir==2){
                i++;
            }
            else if(dir==3){
                j--;
            }
            else{
                i--;
            }
        }
        if(dir==1){
            j--;
        }
        else if(dir==2){
            i--;
        }else if(dir==3){
            j++;
        }else{
            i++;
        }
        ans[0]=i;
        ans[1]=j;
        return ans;
    }
}