// Given a number N, check if a number is perfect or not. A number is said to be perfect if sum of all its factors excluding the number itself is equal to the number. Return 1 if the number is Perfect otherwise return 0.
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
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPerfectNumber(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isPerfectNumber(long N) {
        // code here
        int i; long sum = 1;
        if(N<=1)
        return 0;
        for(i=2;i<Math.sqrt(N);i++)
        {
            if(N%i==0)
            {
            sum += i;
            sum += (N/i);
            }
        }
        if(sum==N)
        return 1;
        else
        return 0;
    }
};