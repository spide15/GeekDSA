# You are given an array arr, you need to find any three elements in it such that arr[i] < arr[j] < arr[k] and i < j < k.

# Note:

# The output will be 1 if the subsequence returned by the function is present in the array arr
# If the subsequence is not present in the array then return an empty array, the driver code will print 0.
# If the subsequence returned by the function is not in the format as mentioned then the output will be -1.
#User function Template for python3



class Solution:
    def find3Numbers(self, arr):
        # Code Here
        left,right=[],[0]*len(arr)
        def nsl(arr):
            nonlocal left
            left.append(-1)
            stack=[arr[0]]
            for i in range(1,len(arr)):
                if stack[-1]<arr[i]:
                    left.append(stack[-1])
                else:
                    while stack and stack[-1]>=arr[i]:
                        stack.pop()
                    if stack:
                        left.append(stack[-1])
                    else:
                        left.append(-1)
                stack.append(arr[i])
        def ngr(arr):
            nonlocal right
            right[-1]=-1
            stack =[arr[-1]]
            for i in range(len(arr)-1,-1,-1):
                if stack[-1]>arr[i]:
                    right[i]=stack[-1]
                else:
                    while stack and stack[-1]<=arr[i]:
                        stack.pop()
                    if stack:
                        right[i]=stack[-1]
                    else:
                        right[i]=-1
                stack.append(arr[i])
        nsl(arr)
        ngr(arr)
        ans=[]
        for i in range(len(arr)):
            if left[i]!=-1 and right[i]!=-1:
                ans=[left[i],arr[i],right[i]]
                return ans
        return ans


#{ 
 # Driver Code Starts
#Initial Template for Python 3


def isSubSequence(v1, v2):
    m = len(v2)
    n = len(v1)
    j = 0  # For index of v2
    # Traverse v1 and v2
    for i in range(n):
        if j < m and v1[i] == v2[j]:
            j += 1
    return j == m


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        n = len(arr)
        obj = Solution()
        res = obj.find3Numbers(arr)
        if len(res) != 0 and len(res) != 3:
            print(-1)
        else:
            if not res:
                print(0)
            elif res[0] < res[1] < res[2] and isSubSequence(arr, res):
                print(1)
            else:
                print(-1)

# } Driver Code Ends