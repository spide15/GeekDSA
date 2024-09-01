# Given two sorted arrays of distinct integers arr1 and arr2. Each array may have some elements in common with the other array. Find the maximum sum of a path from the beginning of any array to the end of any array. You can switch from one array to another array only at the common elements.

# Note:  When we switch from one array to other,  we need to consider the common element only once in the result.
#Your task is to complete this function
#Function should return an integer denoting the required answer
class Solution:
    def maxPathSum(self, arr1, arr2):
        # Code here
        s1,s2,ans,i,j=0,0,0,0,0
        while i<len(arr1) and j<len(arr2):
            if arr1[i]==arr2[j]:
                ans+=max(s1,s2)+arr1[i]
                s1=s2=0
                i+=1
                j+=1
            elif arr1[i]<arr2[j]:
                s1+=arr1[i]
                i+=1
            else:
                s2+=arr2[j]
                j+=1
        ans+=max(s1+sum(arr1[i:]),s2+sum(arr2[j:]))
        return ans

#{ 
 # Driver Code Starts
if __name__ == "__main__":
    t = int(input().strip())
    for _ in range(t):
        arr1 = list(map(int, input().strip().split()))
        arr2 = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.maxPathSum(arr1, arr2)
        print(ans)

# } Driver Code Ends