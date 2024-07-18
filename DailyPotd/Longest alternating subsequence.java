// You are given an array arr. Your task is to find the longest length of a good sequence. A good sequence {x1, x2, .. xn} is an alternating sequence if its elements satisfy one of the following relations :

// 1.  x1 < x2 > x3 < x4 > x5. . . . . and so on
// 2.  x1 >x2 < x3 > x4 < x5. . . . . and so on
//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
//Back-end complete function Template for Java
class Solution {
    public int alternatingMaxLength(int[] arr) {
        // code here
        int increasing=1;
        int decreasing=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                increasing=decreasing+1;
            }else if(arr[i]<arr[i-1]){
                decreasing=increasing+1;
            }
        }
        return Math.max(increasing,decreasing);
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            int ans = obj.alternatingMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends