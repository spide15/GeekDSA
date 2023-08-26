//Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String str, int k) {
        // code here
        if(str==null || str.isEmpty() || str.length()<k){
            return -1;
        }
        int startIdx=0,endIdx=0;
        Map<Character,Integer> set=new HashMap<>();
        int maxLen=0;
        
        while(endIdx<str.length()){
            if(set.size()<k || (set.size()==k && set.containsKey(str.charAt(endIdx)))){
                set.put(str.charAt(endIdx),set.getOrDefault(str.charAt(endIdx),0)+1);
                endIdx++;
                maxLen=Math.max(maxLen,endIdx-startIdx);
                continue;
            }
            while(set.size()==k){
                char ch=str.charAt(startIdx);
                if(set.get(ch)==1){
                    set.remove(ch);
                }else{
                    set.put(ch,set.get(ch)-1);
                    
                }
                startIdx++;
            }
        }
        return maxLen;
    }
}