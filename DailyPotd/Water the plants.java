// A gallery with plants is divided into n parts, numbered 0, 1, 2, 3, ..., n-1. There are provisions for attaching water sprinklers in every division. A sprinkler with range x at division i can water all divisions from i-x to i+x.

// Given an array gallery[] consisting of n integers, where gallery[i] is the range of the sprinkler at partition i (a power of -1 indicates no sprinkler attached), return the minimum number of sprinklers that need to be turned on to water the entire gallery. If there is no possible way to water the full length using the given sprinklers, print -1.
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Solution
{
    class Pair{
        int val,left,right;
        Pair(int val,int left,int right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    int min_sprinklers(int gallery[], int n)
    {
        // code here
        ArrayList<Pair> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(gallery[i]>=0){
                int val=gallery[i];
                int left=(i-val>=0)?i-val:0;
                int right=(i+val<n)?i+val:n-1;
                arr.add(new Pair(val,left,right));
            }
        }
        Collections.sort(arr,(a,b)->{
            return a.left-b.left;
        });
        
        int start=-1;
        int end=-1;
        int idx=0;
        int cnt=0;
        while(end<n-1 && idx<n){
            Pair p=arr.get(idx);
            if(p.left<=start+1){
                end=Math.max(end,p.right);
            }else if(p.left>end+1){
                return -1;
            }else{
                start=end;
                end=p.right;
                cnt++;
            }
            idx++;
        }
        return cnt+1;
    }
}
