// Given a string s of length n, find all the possible subsequences of the string s in lexicographically-sorted order.
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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> ans=new ArrayList<>();
        subseq(s,"",0,ans);
        Collections.sort(ans);
        ans.remove(0);
        return ans;
    }
    void subseq(String s,String ns,int idx,List<String> ans){
        if(s.length()==idx){
            ans.add(ns);
            return;
        }
        
        char ch=s.charAt(idx);
        subseq(s,ns+ch,idx+1,ans);
        subseq(s,ns,idx+1,ans);
    }
}