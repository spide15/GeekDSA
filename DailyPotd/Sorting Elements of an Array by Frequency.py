# Given an array of integers arr, sort the array according to the frequency of elements, i.e. elements that have higher frequency comes first. If the frequencies of two elements are the same, then the smaller number comes first.
#User function Template for python3
 
class Solution:
   
    #Function to sort the array according to frequency of elements.
    def sortByFreq(self,arr):
        #code here
        mp = {}
        for i in range(len(arr)):
            if arr[i] in mp:
                mp[arr[i]] +=1
            else:
                mp[arr[i]] = 1
        
        a = []
        for k,v in mp.items():
            a.append([k,v])
        a.sort()
        a.sort(key=lambda x: x[1], reverse=True)
        # print()
        ans = []
        for k,v in a:
            
            for i in range(v):
                ans.append(k)
        return ans




#{ 
 # Driver Code Starts
#Initial Template for Python 3

import atexit
import io
import sys

_INPUT_LINES = sys.stdin.read().splitlines()
input = iter(_INPUT_LINES).__next__
_OUTPUT_BUFFER = io.StringIO()
sys.stdout = _OUTPUT_BUFFER


@atexit.register
def write():
    sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())


if __name__ == '__main__':
    t = int(input())
    for tt in range(t):

        arr = list(map(int, input().strip().split()))
        l = Solution().sortByFreq(arr)
        print(*l)

# } Driver Code Ends