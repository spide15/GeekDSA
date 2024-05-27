// Given an integer array a[] of size n, find the length of the longest subsequence such that the absolute difference between adjacent elements is 1.
//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class IntArray {
        public static int[] input(BufferedReader br, int n) throws IOException {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
    
            return a;
        }
    
        public static void print(int[] a) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    
        public static void print(ArrayList<Integer> a) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
    
                int n;
                n = Integer.parseInt(br.readLine());
    
                int[] a = IntArray.input(br, n);
    
                Solution obj = new Solution();
                int res = obj.longestSubseq(n, a);
    
                System.out.println(res);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    
    class Solution {
        public static int longestSubseq(int n, int[] a) {
            // code here
             // code here
            return solve(a,0,n,-1);
            
        }
        
        public static int solve(int arr[],int idx ,int n,int prev){
            if(idx >= n){
                return 0;
            }
            
            int max = 0;
            for(int x = idx;x<n;x++){
                int diff = Math.abs(prev-arr[x]);
                if(diff == 1 || prev == -1){
                    max = Math.max(max,1+solve(arr,x+1,n,arr[x]));
                }
                
            }
            
            return max;
        }
    }
    