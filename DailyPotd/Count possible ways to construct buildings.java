// There is a road passing through a city with N plots on both sides of the road. Plots are arranged in a straight line on either side of the road. Determine the total number of ways to construct buildings in these plots, ensuring that no two buildings are adjacent to each other. Specifically, buildings on opposite sides of the road cannot be adjacent.

// Using * to represent a plot and || for the road, the arrangement for N = 3 can be visualized as follows: * * * || * * *.

// Note: As the answer can be very large, print it mod 109+7.
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int mod=1000000007;
    public int TotalWays(int N)
    {
        // Code here
        long poss=0;
        if(N==1)
        poss=2;
        else if(N==2){
            poss=3;
        }else{
            long temp1=2;
            long temp2=3;
            long temp=0;
            for(int i=3;i<=N;i++){
                temp=(temp1+temp2)%mod;
                temp1=temp2;
                temp2=temp;
            }
            poss=temp;
        }
        return (int)((poss*poss)%mod);
    }
}