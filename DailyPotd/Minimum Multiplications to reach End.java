// Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start.

// Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1
//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
         if(start==end) return 0;
        int n=arr.length;
        int mod=100000;
       int[] ans=new int[100001];
       Arrays.fill(ans,-1);
        Queue<Integer> q=new LinkedList<>();
        q.add(start%mod);
        ans[start]=0;
        while(!q.isEmpty()){
            int temp=q.poll();
                if(temp==end) return ans[end];
            for(int i=0;i<n;i++){
                int toPush=(temp%mod*arr[i]%mod)%mod;
                if(ans[toPush]==-1){
                    ans[toPush]=ans[temp]+1;
                    q.add(toPush);
                }
                    
                
            }
            
        }
        return -1;
    }
}
