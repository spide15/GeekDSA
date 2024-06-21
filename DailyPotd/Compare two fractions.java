// You are given a string str containing two fractions a/b and c/d, compare them and return the greater. If they are equal, then return "equal".

// Note: The string str contains "a/b, c/d"(fractions are separated by comma(,) & space( )). 
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

      String compareFrac(String str) {
        String numbers[] = str.split("[/,\\s]+");
        double a = (Double.parseDouble(numbers[0])) / (Double.parseDouble(numbers[1]));
        double b = (Double.parseDouble(numbers[2])) / (Double.parseDouble(numbers[3]));
        
        if (a > b){
            return (numbers[0] + "/" + numbers[1]);
        }
        else if (b > a){
            return (numbers[2] + "/" +numbers[3]);
        }
        else{
            return "equal";
        }
    }
}
