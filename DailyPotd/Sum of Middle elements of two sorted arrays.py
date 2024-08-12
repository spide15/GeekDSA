# Given 2 sorted integer arrays arr1 and arr2 of the same size. Find the sum of the middle elements of two sorted arrays arr1 and arr2.
#User function Template for python3

class Solution:
    def sum_of_middle_elements(self, arr1, arr2):
        # code here
        arr=[]
        arr[:]=arr1+arr2
        arr.sort()
        mid=len(arr)//2
        return arr[mid-1]+arr[mid]


#{ 
 # Driver Code Starts
#Initial Template for Python 3

import sys

input = sys.stdin.read


def main():
    input_lines = input().strip().split("\n")
    t = int(input_lines[0])

    index = 1
    results = []
    while t > 0:
        arr = list(map(int, input_lines[index].strip().split()))
        brr = list(map(int, input_lines[index + 1].strip().split()))
        index += 2

        solution = Solution()
        res = solution.sum_of_middle_elements(arr, brr)
        results.append(res)

        t -= 1

    for result in results:
        print(result)


if __name__ == "__main__":
    main()

# } Driver Code Ends