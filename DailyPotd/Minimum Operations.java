// Given a number N. Find the minimum number of operations required to reach N starting from 0. You have 2 operations available:

// Double the number
// Add one to the number
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
        //code here.  
        int cur=0;
    while(n>0)
    {
        if(n%2==0)n/=2;
        else n-=1;
        
        cur++;
    }
    
    return cur;
    }
}