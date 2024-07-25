# Given a sorted array. Convert it into a Height Balanced Binary Search Tree (BST). Return the root of the BST.

# Height-balanced BST means a binary tree in which the depth of the left subtree and the right subtree of every node never differ by more than 1.

# Note: The driver code will check the BST, if it is a Height-balanced BST, the output will be true otherwise the output will be false.
#User function Template for python3
class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.data=val
        self.left=left
        self.right=right


class Solution:
    def sortedArrayToBST(self, nums):
        # code here
        if not nums:
            return None
        mid=len(nums)//2
        root=TreeNode(nums[mid])
        
        root.left=self.sortedArrayToBST(nums[:mid])
        root.right=self.sortedArrayToBST(nums[mid+1:])
        
        return root


#{ 
 # Driver Code Starts
from collections import deque


# Tree Node
class Node:

    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None


def help(root, up, l):
    if root.data >= up or root.data <= l:
        return False
    ans = True
    if root.left:
        ans = help(root.left, root.data, l)
    if ans and root.right:
        ans = help(root.right, up, root.data)
    return ans


def isValidBST(root):
    return help(root, 3147483648, -3147483649)


def height(root):
    if root is None:
        return 0
    leftHeight = height(root.left)
    rightHeight = height(root.right)
    if leftHeight == -1 or rightHeight == -1 or abs(leftHeight -
                                                    rightHeight) > 1:
        return -1
    return max(leftHeight, rightHeight) + 1


def isBalanced(root):
    if root is None:
        return True
    return height(root) != -1


def inorder(root, v):
    if root is None:
        return
    inorder(root.left, v)
    v.append(root.data)
    inorder(root.right, v)


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))

        solution = Solution()
        root = solution.sortedArrayToBST(arr)

        v = []
        inorder(root, v)

        if not isValidBST(root) or v != arr:
            print("false")
            continue

        if isBalanced(root):
            print("true")
        else:
            print("false")

# } Driver Code Ends