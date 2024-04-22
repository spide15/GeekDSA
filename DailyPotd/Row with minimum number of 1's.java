// Given a 2D binary matrix(1-based indexed) a of dimensions nxm , determine the row that contains the minimum number of 1's.
// Note: The matrix contains only 1's and 0's. Also, if two or more rows contain the minimum number of 1's, the answer is the lowest of those indices.
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int A[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    A[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.minRow(N, M, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minRow(int n, int m, int a[][]) {
        // code here
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0; i < n ; i++){
            int count = 0;
            for(int j = 0; j < m ; j++){
                if(a[i][j] == 1){
                    count++;
                }
            }
            if(count < ans){
                ans = count;
                idx = i;
            }
        }
        return idx+1;
    }
};