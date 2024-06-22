// Given a sentence containing several words and numbers. Find the largest number among them which does not contain 9. If no such number exists, return -1.

// Note: Numbers and words are separated by spaces only. It is guaranteed that there are no leading zeroes in the answer.
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
          String split[]=sentence.split(" ");
       
        long ans=0;
        for(int i=0;i<split.length;i++)
        {
            String res=split[i];
            if(!Character.isLetter(res.charAt(0)))
            {
               if(res.indexOf("9")==-1)
               {
                   if(ans<Long.parseLong(res))
                   {
                   ans=Long.parseLong(res);
                   }
               }
            }
        }
        if(ans!=0)
        {
        return ans;
        }
        else
        {
            return -1;
        }
    }
}