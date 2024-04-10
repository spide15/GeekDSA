// You are given an integer array arr[] of size n, representing n number of people in a party, each person is denoted by an integer. Couples are represented by the same number ie: two people have the same integer value, it means they are a couple. Find out the only single person in the party of couples.

// NOTE: It is guarantee that there exist only one single person in the party.
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.findSingle(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int findSingle(int n, int arr[]){
        // code here
          int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=ans^arr[i];
        }
        return ans;
    }
}