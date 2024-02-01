// Given a string s check if it is "Panagram" or not.

// A "Panagram" is a sentence containing every letter in the English Alphabet.
//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
       int[] arr = new int[26];
        
        for(int i=0;i<s.length();i++){
            char c = Character.toLowerCase(s.charAt(i));
            if((c - 'a') >= 0 && c - 'a' <= 26){
                arr[c -'a']++;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                return false;
            }
        }
        return true;
    }
}

//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends