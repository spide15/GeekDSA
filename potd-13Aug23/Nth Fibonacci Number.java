// problem
// Given a positive integer n, find the nth fibonacci number. Since the answer can be very large, return the answer modulo 1000000007.

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

// User function Template for Java
class Solution {
    static int nthFibonacci(int n) {
        // code here
        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;
        int mod = 1000000007;
        for (int i = 2; i < n; i++) {
            fib[i] = (fib[i - 1]) % mod + (fib[i - 2]) % mod;
        }
        return fib[n - 1] % mod;
    }
}