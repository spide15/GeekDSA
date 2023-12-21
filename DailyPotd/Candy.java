// There are N children standing in a line. Each child is assigned a rating value given in the integer array ratings.
// You are giving candies to these children subjected to the following requirements:

// Each child must have atleast one candy.
// Children with a higher rating than it's neighbours get more candies than neighbors.
// Return the minimum number of candies you need to have to distribute.
//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minCandy(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minCandy(int N, int ratings[]) {
        // code here
        int[] candies=new int [N];
        Arrays.fill(candies,1);
        for(int i=1;i<N;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
                
            }
        }
            for(int i=N-1;i>0;i--){
                if(ratings[i]<ratings[i-1]&& candies[i]>=candies[i-1]){
                    candies[i-1]=candies[i]+1;
                }
            }
            return Arrays.stream(candies).sum();
        
    }
}
