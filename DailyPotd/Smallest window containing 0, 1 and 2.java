// Given a string S consisting of the characters 0, 1 and 2. Your task is to find the length of the smallest substring of string S that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1.
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String s) {
        // Code here
        int n=s.length();
        int minL=n+1;
        int i=0,j=0;
        Map<Character,Integer> map=new HashMap<>();
        while(j<n)
        {
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            while(i<n && map.size()==3){
                minL=Math.min(minL,j-i+1);
                
                ch=s.charAt(i);
                map.put(ch,map.get(ch)-1);
                
                if(map.get(ch)==0)
                map.remove(ch);
                
                i++;
            }
            j++;
        }
        return minL==n+1?-1:minL;
    }
};
