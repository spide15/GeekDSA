// // Given a number n, find the nth number in the Padovan Sequence.

// // A Padovan Sequence is a sequence which is represented by the following recurrence relation
// // P(n) = P(n-2) + P(n-3)
// // P(0) = P(1) = P(2) = 1

// // Note: Since the output may be too large, compute the answer modulo 10^9+7.
// //{ Driver Code Starts
// //Initial Template for Java

// import java.io.*;
// import java.util.*;
// class GfG
// {
//     public static void main(String args[])
//         {
//             Scanner sc = new Scanner(System.in);
//             int t = sc.nextInt();
//             while(t-->0)
//                 {
//                     int n = sc.nextInt();
//                     Solution ob = new Solution();
//                     System.out.println(ob.padovanSequence(n));
//                 }
//         }
// }    
// // } Driver Code Ends


// //User function Template for Java

// class Solution
// {
//    private static final int MOD = 1000000007;

//     public static int padovanSequence(int n) {
//         // Base cases
//         if (n == 0 || n == 1 || n == 2) {
//             return 1;
//         }

//         // Initialize the first three Padovan numbers
//         int p0 = 1, p1 = 1, p2 = 1;

//         // Variable to store the current Padovan number
//         int pCurrent = 0;

//         // Compute Padovan numbers iteratively from P3 to Pn
//         for (int i = 3; i <= n; i++) {
//             pCurrent = (p0 + p1) % MOD;
//             p0 = p1;
//             p1 = p2;
//             p2 = pCurrent;
//         }

//         return pCurrent;
//     }
// }
