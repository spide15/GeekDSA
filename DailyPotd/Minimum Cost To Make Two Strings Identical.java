// Given two strings x and y, and two values costX and costY, the task is to find the minimum cost required to make the given two strings identical. You can delete characters from both the strings. The cost of deleting a character from string X is costX and from Y is costY. The cost of removing all characters from a string is the same.
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String X = sc.next();
            String Y = sc.next();
            int costX = sc.nextInt();
            int costY = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.findMinCost(X, Y, costX, costY));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
        int n = x.length();
        int m = y.length();
        
        // Create a 2D array to store the lengths of LCS
        int[][] dp = new int[n + 1][m + 1];
        
        // Fill the dp tableA
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        int lcsLength = dp[n][m];
        int minCost = (n - lcsLength) * costX + (m - lcsLength) * costY;
        
        return minCost;
    }
}
