// Given a two-dimensional integer array arr of dimensions n x n, consisting solely of zeros and ones, identify the row or column (using 0-based indexing) where all elements form a palindrome. If multiple palindromes are identified, prioritize the palindromes found in rows over those in columns. Within rows or columns, the palindrome with the smaller index takes precedence. The result should be represented by the index followed by either 'R' or 'C', indicating whether the palindrome was located in a row or column. The output should be space-separated. If no palindrome is found, return the string -1.
//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean isPalindrome(int[][] arr,int index,boolean isRow){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            if(isRow){
                if(arr[index][left]!=arr[index][right]){
                    return false;
                }
            }else{
                if(arr[left][index]!=arr[right][index]){
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }
    public String pattern(int[][] arr) {
        // Code here
        int n=arr.length;
        for (int i=0;i<n;i++){
            if(isPalindrome(arr,i,true)){
                return i+" R";
            }
        }
        for(int j=0;j<n;j++){
            if(isPalindrome(arr,j,false)){
                return j+" C";
            }
        }
        
        return "-1";
    }
}
