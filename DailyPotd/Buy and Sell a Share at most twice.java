// in daily share trading, a buyer buys shares in the morning and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, the second transaction can only start after the first one is complete (buy->sell->buy->sell). The stock prices throughout the day are represented in the form of an array of prices. 

// Given an array price of size n, find out the maximum profit that a share trader could have made.
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
            t = Integer.parseInt(br.readLine().trim());
            while(t-- > 0){
                
                int n; 
                n = Integer.parseInt(br.readLine().trim());
                
                
                int[] price = IntArray.input(br, n);
                
                Solution obj = new Solution();
                int res = obj.maxProfit(n, price);
                
                System.out.println(res);
                
            }
        }
    }
    
    // } Driver Code Ends
    
    
    class Solution {
        public static int maxProfit(int n, int[] price) {
            // code here
            if(n<=1){
                return 0;
            }
            int profit_first[] = new int[n+1];
            int profit_sec[] = new int[n+1];
            
            int first_min = price[0];
            for(int i=1;i<n;i++){
                first_min = Math.min(first_min,price[i]);
                profit_first[i] = Math.max(profit_first[i-1],price[i]-first_min);
            }
            
            int sec_max = price[n-1];
            for(int i=n-2;i>=0;i--){
                sec_max = Math.max(price[i],sec_max);
                profit_sec[i] = Math.max(profit_sec[i+1],sec_max-price[i]);
            }
            
            int ans = 0;
            for(int i=0;i<n;i++){
                ans = Math.max(ans,profit_first[i]+profit_sec[i]);
            }
            return ans;
        }
    }
            
    