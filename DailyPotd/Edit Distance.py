# Given two strings str1 and str2. Return the minimum number of operations required to convert str1 to str2.
# The possible operations are permitted:

# Insert a character at any position of the string.
# Remove any character from the string.
# Replace any character from the string with any other character.
class Solution:
	def editDistance(self, str1, str3):
		# Code here
		N,M=len(str1),len(str3)
		dp=[[0]*(M+1) for _ in range(N+1)]
# 		print(dp)
		for i in range(N+1):
		    for j in range(M+1):
		        if i==0 or j==0:
		            dp[i][j]=i+j
		        else:
		            if str1[i-1]==str3[j-1]:
		                dp[i][j]=dp[i-1][j-1]
		            else:
		                dp[i][j]=1+min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])
	    return dp[N][M]


#{ 
 # Driver Code Starts
if __name__ == '__main__':
    T = int(input())
    for i in range(T):
        s, t = input().split()
        ob = Solution()
        ans = ob.editDistance(s, t)
        print(ans)

# } Driver Code Ends