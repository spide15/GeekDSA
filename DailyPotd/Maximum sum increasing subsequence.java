// Given an array of n positive integers. Find the sum of the maximum sum subsequence of the given array such that the integers in the subsequence are sorted in strictly increasing order i.e. a strictly increasing subsequence.
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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int omax=arr[0];
	    int dp[]=new int[n];
	    dp[0]=arr[0];
	    for(int i=1;i<n;i++){
	        int max=0;
	        for(int j=0;j<n;j++){
	            if(arr[j]<arr[i]){
	                max=Math.max(max,dp[j]);
	            }
	        }
	        dp[i]=max+arr[i];
	        omax=Math.max(omax,dp[i]);
	    }
	    return omax;
	}  
}