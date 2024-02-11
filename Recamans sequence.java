// Given an integer n, return the first n elements of Recaman’s sequence.
// It is a function with domain and co-domain as whole numbers. It is recursively defined as below:
// Specifically, let a(n) denote the (n+1)th term. (0 being the 1st term).
// The rule says:
// a(0) = 0
// a(n) = a(n-1) - n, if a(n-1) - n > 0 and is not included in the sequence previously
//        =  a(n-1) + n otherwise.
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> seq=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        
        seq.add(0);
        set.add(0);
        int i=1;
        while(i<n){
            int ans=seq.get(i-1)-i;
            if(ans<0 || set.contains(ans)){
                ans=seq.get(i-1)+i;
            }
            i++;
            seq.add(ans);
            set.add(ans);
        }
        return seq;
    }
}