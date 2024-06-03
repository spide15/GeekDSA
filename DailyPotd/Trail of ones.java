// Given a number n, find the number of binary strings of length n that contain consecutive 1's in them. Since the number can be very large, return the answer after modulo with 1e9+7.
//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
     private static final int MOD = 1000000007;

 

    public static int numberOfConsecutiveOnes(int n) {

        if (n == 1) return 0; // edge case, although n >= 2 according to constraints

        

        // Initialize dp array

        long[] dp = new long[n + 1];

        dp[1] = 2; // "0", "1"

        dp[2] = 3; // "00", "01", "10"

        

        // Fill dp array based on the recurrence relation

        for (int i = 3; i <= n; i++) {

            dp[i] = (dp[i-1] + dp[i-2]) % MOD;

        }

        

        // Total binary strings of length n

        long totalStrings = power(2, n);

        

        // Subtract the number of valid strings from the total to get the number of strings with consecutive 1's

        long result = (totalStrings - dp[n] + MOD) % MOD;

        return (int) result;

    }

 

    // Function to calculate power with modulo

    private static long power(int base, int exp) {

        long result = 1;

        long b = base;

        

        while (exp > 0) {

            if ((exp & 1) == 1) {

                result = (result * b) % MOD;

            }

            b = (b * b) % MOD;

            exp >>= 1;

        }

        

        return result;

    }
}
