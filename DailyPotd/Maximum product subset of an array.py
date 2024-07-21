# Given an array arr. The task is to find and return the maximum product possible with the subset of elements present in the array.

# Note:

# The maximum product can be a single element also.
# Since the product can be large, return it modulo 109 + 7.
#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
#User function Template for python3
class Solution:
    def findMaxProduct(self, arr):
        # Write your code here
        n=len(arr)
        if n==1:
            return arr[0]
        neg,zero=0,0
        ans=1
        flg=False
        for i in range(n):
            if arr[i]>0:
                ans*=arr[i]
                flg=True
            if arr[i]<0:
                neg+=1
            if arr[i]==0:
                zero+=1
        neg=(neg//2)*2
        arr.sort()
        for i in range(neg):
            ans*=arr[i]
            flg=True
        if not flg:
            ans=max(arr)
        return (ans%(10**9+7))
    


#{ 
 # Driver Code Starts.
if __name__ == "__main__":
    import sys
    input = sys.stdin.read
    data = input().split()

    index = 0
    t = int(data[index])
    index += 1
    results = []
    
    for _ in range(t):
        n = int(data[index])
        index += 1
        arr = list(map(int, data[index:index + n]))
        index += n
        solution = Solution()
        ans = solution.findMaxProduct(arr)
        results.append(ans)
    
    for result in results:
        print(result)
# } Driver Code Ends