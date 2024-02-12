// A function F is defined as follows F(n)= (1) +(2*3) + (4*5*6) ... upto n terms (look at the examples for better clarity). Given an integer n, determine the F(n).

// Note: As the answer can be very large, return the answer modulo 109+7.
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long sequence(int n){
        // code here
        long s=1;
        long sum=0;
        for(int i=1;i<=n;i++){
            long k=1;
            for(int j=1;j<=i;j++){
                k=(k*s)%(1000000007);
                s++;
            }
            sum=(sum+k)%(1000000007);
        }
        return sum;
    }
}