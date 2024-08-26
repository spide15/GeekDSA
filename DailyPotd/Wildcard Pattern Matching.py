# Given two strings pattern and str which may be of different size, You have to return 1 if the wildcard pattern i.e. pattern, matches with str else return 0. All characters of the string str and pattern always belong to the Alphanumeric characters.

# The wildcard pattern can include the characters ? and *
# ‘?’ – matches any single character.
# ‘*’ – Matches any sequence of characters (including the empty sequence).

# Note: The matching should cover the entire str (not partial str).
# your task is to complete this function
# function should return True/False or 1/0
# str1: pattern
# str2: text
class Solution:
    def wildCard(self,pattern, string):
        # Code here
        pN,sN=len(pattern),len(string)
        dp=[[None]*(sN+1) for _ in range(pN+1)]
        for p in range(pN+1):
            for s in range(sN+1):
                if p==0 and s==0:
                    dp[p][s]=True
                elif p==0:
                    dp[p][s]=False
                elif s==0 and pattern[p-1]=="*":
                    dp[p][s]=dp[p-1][s]
                elif s==0:
                    dp[p][s]=False
                elif pattern[p-1]!="*" and pattern[p-1]!="?" and pattern[p-1]!=string[s-1]:
                    dp[p][s]=False
                else:
                    dp[p][s]=False
                    if pattern[p-1]=="*":
                        dp[p][s]= dp[p][s] or dp[p-1][s]
                        dp[p][s]= dp[p][s] or dp[p][s-1]
                    dp[p][s]= dp[p][s] or dp[p-1][s-1]
        return dp[pN][sN]



#{ 
 # Driver Code Starts
if __name__ == '__main__':
    t = int(input())
    for i in range(t):
        pattern = input().strip()
        string = input().strip()
        if Solution().wildCard(pattern, string):
            print(1)
        else:
            print(0)

# } Driver Code Ends