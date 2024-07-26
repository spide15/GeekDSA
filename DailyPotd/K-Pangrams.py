# Given a string str and an integer k, return true if the string can be changed into a pangram after at most k operations, else return false.

# A single operation consists of swapping an existing alphabetic character with any other lowercase alphabetic character.

# Note - A pangram is a sentence containing every letter in the english alphabet.
#User function Template for python3
class Solution:
    def kPangram(self,string, k):
        total,unique,isPresent=0,0,[False]*26
        for val in string:
            if val.isalpha():
                total+=1
                i=ord(val)-ord("a")
                if not isPresent[i]:
                    isPresent[i]=True
                    unique+=1
        return 26-unique<=k and total>=26
    # code here


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    T = int(input())

    for tcs in range(T):
        string = input()
        K = int(input())
        ob = Solution()
        a = ob.kPangram(string, K)
        if a:
            print("true")
        else:
            print("false")

# } Driver Code Ends