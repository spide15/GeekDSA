// Given a sorted array arr[] of positive integers. The task is to find the closest value in the array to the given number k. The array may contain duplicate values.

// Note: If the difference with k is the same for two values in the array return the greater value.
//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    
    class IntArray
    {
        public static int[] input(BufferedReader br, int n) throws IOException
        {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
    
            return a;
        }
    
        public static void print(int[] a)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    
        public static void print(ArrayList<Integer> a)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                
                int n;
                n = Integer.parseInt(br.readLine());
                
                
                int k;
                k = Integer.parseInt(br.readLine());
                
                
                int[] arr = IntArray.input(br, n);
                
                Solution obj = new Solution();
                int res = obj.findClosest(n, k, arr);
                
                System.out.println(res);
                
            }
        }
    }
    
    // } Driver Code Ends
    
    
    
    class Solution {
        public static int findClosest(int n, int k, int[] arr) {
            // code here
                  int left=0;
            int right=n-1;
            while(left<=right) {
                int mid=(left+right)>>1;
                if(k<arr[mid]) {
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
            
            if(left==arr.length)return arr[right];
            if(right<0)return arr[left];
            
            int ans=arr[left];
            int diff=Math.abs(k-ans);
            if(diff>Math.abs(k-arr[right])) ans=arr[right];
            return ans;
        }
    }
            
    