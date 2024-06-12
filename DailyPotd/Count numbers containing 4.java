// You are given a number n, Return the count of total numbers from 1 to n containing 4 as a digit.
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.countNumberswith4(n);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countNumberswith4(int n) {
        // code here
        int i=1;
        int count=0;
        while(i<=n){
            String temp=String.valueOf(i);
            StringBuilder s=new StringBuilder(temp);
            if(s.indexOf("4")!=-1){
                count++;
            }
            i++;
        }
        return count;
    }
}
