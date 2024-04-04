// Given an integer s represented as a string, the task is to get the sum of all possible sub-strings of this string.
// As the answer will be large, return answer modulo 109+7. 

// Note: The number may have leading zeros.
//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
    //Your code here
    int MOD = 1000000007;
    long prev=0;
    long curr=0;
    long sum=0;
    for(int i=0;i<s.length();i++){
        curr=((s.charAt(i)-'0')*(i+1))%MOD+(prev*10)%MOD;
        sum=(sum+curr)%MOD;
        prev=curr;
    }
    return sum;
    }
}