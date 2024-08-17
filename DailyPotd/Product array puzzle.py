# Given an array nums[], construct a Product Array nums[] such that nums[i] is equal to the product of all the elements of nums except nums[i].
#User function Template for python3

class Solution:
    def productExceptSelf(self, nums):
        #code here
        m=len(nums)
        pref=[1]+[None]*m
        for ix,ve in enumerate(nums):
            pref[ix+1]=pref[ix]*ve
        suff=1
        ret=[None]*m
        for ix in range(m-1,-1,-1):
            ret[ix]=pref[ix]*suff
            suff=suff*nums[ix]
        return ret


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())

    for _ in range(t):
        n = int(input())
        arr = [int(x) for x in input().split()]

        ans = Solution().productExceptSelf(arr)
        print(*ans)

# } Driver Code Ends