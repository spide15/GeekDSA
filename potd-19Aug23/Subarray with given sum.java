// Given an unsorted array A of size N that contains only positive integers, find a continuous sub-array that adds to a given number S and return the left and right index(1-based indexing) of that subarray.

// In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.

// Note:- You have to return an ArrayList consisting of two elements left and right. In case no such subarray exists return an array consisting of element -1.

//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class Main{
        static BufferedReader br;
        static PrintWriter ot;
        public static void main(String[] args) throws IOException{
            
            br = new BufferedReader(new InputStreamReader(System.in));
            ot = new PrintWriter(System.out);
    
            int t = Integer.parseInt(br.readLine());
    
            while(t-->0){
                
                String s[] = br.readLine().trim().split(" ");
                
                int n = Integer.parseInt(s[0]);
                int k = Integer.parseInt(s[1]);
                int a[] = new int[n];
                s = br.readLine().trim().split(" ");
                for(int i = 0; i < n; i++)
                    a[i] = Integer.parseInt(s[i]);
                Solution obj = new Solution();
                ArrayList<Integer> res = obj.subarraySum(a, n, k);
                for(int ii = 0;ii<res.size();ii++)
                    ot.print(res.get(ii) + " ");
                ot.println();
            }
            ot.close();
        }
    
    }
    // } Driver Code Ends
    
    
    class Solution
    {
        //Function to find a continuous sub-array which adds up to a given number.
        static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
        {
            // Your code here
            int sum=0;
            ArrayList<Integer> ans=new ArrayList<>();
            int i=0;
            int j=0;
            while(j<n){
                sum+=arr[j];
                while(sum>=s && i<=j){
                    if(sum==s){
                        ans.add(i+1);
                        ans.add(j+1);
                        return ans;
                    }
                    sum-=arr[i];
                    i++;
                }
                j++;
            }
            
            ans.add(-1);
            return ans;
            
        }
    }