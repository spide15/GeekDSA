// Given a string consisting of lower case English alphabets, the task is to find the number of distinct subsequences of the string
// Note: Answer can be very large, so, ouput will be answer modulo 109+7.
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctSubsequences(String s) {
        // code here
         int mod = 1000000007;
        int dp[] = new int[s.length()+1];
        dp[0] = 1;
        
        int ch[] = new int[26];
        
        for(int i=1;i<dp.length;i++){
            int val = ch[s.charAt(i-1)-'a'];
            dp[i] = ((2 * dp[i-1])%mod) - val;
            dp[i] %= mod;
            ch[s.charAt(i-1) - 'a'] = dp[i-1];
        }
        int ans = (dp[s.length()]+mod)%mod;
        return ans;
    }
}