// Apply to 6 Companies through 1 Contest!  

// banner
// You are given an array a, of n elements. Find the minimum index based distance between two distinct elements of the array, x and y. Return -1, if either x or y does not exist in the array.
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = Integer.parseInt(str[i]);
            String[] xy = br.readLine().trim().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            Solution g = new Solution();
            System.out.println(g.minDist(a, n, x, y));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minDist(int a[], int n, int x, int y) {
        // code here
        int x1=-1;
        int y1=-1;
        int dist=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]==x){
                x1=i;
                 if(y1!=-1){
                dist=Math.min(dist,Math.abs(x1-y1));
                 }
            }
             else if(a[i]==y){
                y1=i;
                 if(x1!=-1){
                    dist=Math.min(dist,Math.abs(x1-y1));
                }
            }
           
            
        }
        return dist==Integer.MAX_VALUE?-1:dist;
    }
}