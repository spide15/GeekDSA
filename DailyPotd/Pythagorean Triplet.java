// Given an array arr of n integers, write a function that returns true if there is a triplet (a, b, c) from the array (where a, b, and c are on different indexes) that satisfies a2 + b2 = c2, otherwise return false.
//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    boolean checkTriplet(int[] arr, int n) {
        // code here
        HashSet<Long> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add((long)arr[i]*arr[i]);
        }
        
        for(int i=0;i<n-1;i++){
            for(int j=1;j<n;j++){
                long ans=(long)(arr[i]*arr[i])+(long)(arr[j]*arr[j]);
                if(set.contains(ans)){
                    return true;
                }
            }
        }
        return false;
    }
}