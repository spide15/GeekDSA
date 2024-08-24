# You are given weights and values of items, and put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
# In other words, given two integer arrays val and wt which represent values and weights associated with items respectively. Also given an integer W which represents knapsack capacity, find out the maximum sum values subset of val[] such that the sum of the weights of the corresponding subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don't pick it (0-1 property).
#User function Template for python3

class Solution:
    
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt, val):
       
        # code here
          # code here
        N = len(wt) 
        DP = [[0 for i in range(W+1)] for j in range(N+1)]
        
        for i in range(1, N+1):
            for w in range(1, W+1):
                
                j = w-wt[i-1]
                
                if j >= 0 :
                    DP[i][w] = max(DP[i-1][w], (DP[i-1][j]+val[i-1]))
                else:
                    DP[i][w] = DP[i-1][w]  
                
        return DP[N][W] 


#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases):
        # n = int(input())
        W = int(input())
        val = list(map(int, input().strip().split()))
        wt = list(map(int, input().strip().split()))
        ob = Solution()
        print(ob.knapSack(W, wt, val))

# } Driver Code Ends