// Given an array A of integers and another number K. Find all the unique quadruple from the given array that sums up to K.

// Also note that all the quadruples which you return should be internally sorted, ie for any quadruple [q1, q2, q3, q4] the following should follow: q1 <= q2 <= q3 <= q4.
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        int n= arr.length;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
                if(n==0 ) return res;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int left=j+1;
                int right= n-1;
                while(left<right)
                {
                    int sum=arr[i]+arr[j]+arr[left]+arr[right];
                    if(sum<k) left++;
                    else if(sum>k) right--;
                    else{
                        ArrayList<Integer> a1=new ArrayList<>();
                        a1.add(arr[i]);
                        a1.add(arr[j]);
                        a1.add(arr[left]);
                        a1.add(arr[right]);
                        res.add(a1);
                        while(left<right && arr[left]== a1.get(2))left++;
                        while(left<right && arr[right]==a1.get(3)) right--;
                    }
                }
                while(j+1<n && arr[j]==arr[j+1]) j++;
            }
            while(i+1<n && arr[i]==arr[i+1]) i++;
        }
        return res;
    }
}