// Given three numbers n, x, and y, Geek and his friend are playing a coin game. In the beginning, there are n coins. In each move, a player can pick x, y, or 1 coin. Geek always starts the game. The player who picks the last coin wins the game. The task is to determine whether Geek will win the game or not if both players play optimally.
//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
    
                int n;
                n = Integer.parseInt(br.readLine());
    
                int x;
                x = Integer.parseInt(br.readLine());
    
                int y;
                y = Integer.parseInt(br.readLine());
    
                Solution obj = new Solution();
                int res = obj.findWinner(n, x, y);
    
                System.out.println(res);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    
    class Solution {
        public static int findWinner(int n, int x, int y) {
            // code here
            boolean dp[] = new boolean[n + 1];
            if(n >= 1)
                dp[1] = true;
                
            for(int i = 2; i <= n; i++) {
                if(i - 1 >= 0 && dp[i - 1] == false)
                    dp[i] = true;
                else if(i - x >= 0 && dp[i - x] == false)
                    dp[i] = true;
                else if(i - y >= 0 && dp[i - y] == false)
                    dp[i] = true;
            }
            
            return dp[n] == true ? 1 : 0;
        }
    }
    