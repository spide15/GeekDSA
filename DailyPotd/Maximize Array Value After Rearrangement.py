# Given an array arr of n integers. Your task is to write a program to find the maximum value of ∑arr[i]*i, where i = 0, 1, 2,., n-1. You are allowed to rearrange the elements of the array.

# Note: Since the output could be large, print the answer modulo 109+7.
#User function Template for python3

class Solution:
    def Maximize(self, a): 
        # Complete the function
        a.sort()
        sm=0
        for i in range(len(a)):
            sm=(sm+a[i]*i%1000000007)%1000000007
        return sm
            
      



#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())

    for _ in range(t):
        A = list(map(int, input().strip().split()))
        # k = int(input())
        ob = Solution()
        print(ob.Maximize(A))

# } Driver Code Ends