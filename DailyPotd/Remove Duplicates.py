# Given a string str without spaces, the task is to remove all duplicate characters from it, keeping only the first occurrence.

# Note: The original order of characters must be kept the same.
#User function Template for python3
class Solution:
	def removeDups(self, str):
		# code here
		seen=set()
		result=[]
		for char in str:
		    if char not in seen:
		        seen.add(char)
		        result.append(char)
	    return ''.join(result)
# # 		 return " ".join(result)
# # 		 print(result)
		 
        # seen = set()   # 🗂️ To keep track of seen characters
        # result = []    # 📃 To build the result string
        # for char in str:   # 🔍 Loop through each character in the input string
        #     if char not in seen:   # ❓ Check if the character is not in the seen set
        #         seen.add(char)     # ➕ Add the character to the seen set
        #         result.append(char)  # ✏️ Add the character to the result list
        # return ''.join(result) 


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    T = int(input())
    for i in range(T):
        s = input()

        ob = Solution()
        answer = ob.removeDups(s)

        print(answer)

# } Driver Code Ends