// Given two integers m and n, try making a special sequence of numbers seq of length n such that

// seqi+1 >= 2*seqi 
// seqi > 0
// seqi <= m
// Your task is to determine total number of such special sequences possible.
//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberSequence(int m, int n)
    {
        // code here
        if(n==0)
        return 1;
        
        if(n>m)
        return 0;
        
        return numberSequence(m/2,n-1)+numberSequence(m-1,n);
    }
}