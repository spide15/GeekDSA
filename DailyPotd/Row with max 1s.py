# Given a boolean 2D array, consisting of only 1's and 0's, where each row is sorted. Return the 0-based index of the first row that has the most number of 1s. If no such row exists, return -1.
#User function Template for python3
class Solution:

	def rowWithMax1s(self,arr):
		# code here
		n,r,c,ind=len(arr),0,len(arr[0])-1,-1
		while r<n and c>=0:
		    if arr[r][c]==1:
		        ind,c=r,c-1
		    else:
		        r+=1
		return ind


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n, m = list(map(int, input().strip().split()))

        inputLine = list(map(int, input().strip().split()))
        arr = [[0 for j in range(m)] for i in range(n)]

        for i in range(n):
            for j in range(m):
                arr[i][j] = inputLine[i * m + j]
        ob = Solution()
        ans = ob.rowWithMax1s(arr)
        print(ans)
        tc -= 1

# } Driver Code Ends