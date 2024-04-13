// Given a number x, reverse its binary form and return the answer in decimal.
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static Long reversedBits(Long x) {
        // code here
        x = ((x & 0x55555555) << 1) | ((x & 0xAAAAAAAA) >>> 1);
        x = ((x & 0x33333333) << 2) | ((x & 0xCCCCCCCC) >>> 2);
        x = ((x & 0x0F0F0F0F) << 4) | ((x & 0xF0F0F0F0) >>> 4);
        x = ((x & 0x00FF00FF) << 8) | ((x & 0xFF00FF00) >>> 8);
        x = ((x & 0x0000FFFF) << 16) | ((x & 0xFFFF0000) >>> 16);
        return x;
    }
};