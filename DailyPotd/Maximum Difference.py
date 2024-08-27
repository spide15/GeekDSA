# Given an integer array arr of integers, the task is to find the maximum absolute difference between the nearest left smaller element and the nearest right smaller element of every element in array arr. If for any component of the arr, the nearest smaller element doesn't exist then consider it as 0.
class Solution:
    def findMaxDiff(self, arr):
        # code here
        
        l=[]
        x=True
        for i in range(0,len(arr)):
            if i==len(arr)-1:
                l.append(0)
                break
            for j in range(i+1,len(arr)):
                if arr[j]<arr[i]:
                    l.append(arr[j])
                    x=True
                    break
                else:
                    x=False
            if x==False:
                l.append(0)
        arr.reverse()
        l1=[]
        y=True
        for i in range(0,len(arr)):
            if i==len(arr)-1:
                l1.append(0)
                break
            for j in range(i+1,len(arr)):
                if arr[j]<arr[i]:
                    l1.append(arr[j])
                    y=True
                    break
                else:
                    y=False
            if y==False:
                l1.append(0)
        l1.reverse()
        x=[]
        for i in range(0,len(l)):
            x.append(abs(l[i]-l1[i]))
        return max(x)
        return 0


#{ 
 # Driver Code Starts
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        ob = Solution()
        print(ob.findMaxDiff(arr))

# } Driver Code Ends