# Given the root of a binary tree. Check whether it is a BST or not.
# Note: We are considering that BSTs can not contain duplicate Nodes.
# A BST is defined as follows:

# The left subtree of a node contains only nodes with keys less than the node's key.
# The right subtree of a node contains only nodes with keys greater than the node's key.
# Both the left and right subtrees must also be binary search trees.
#User function Template for python3


class Solution:
    
    def is_bst(self,node,min_val,max_val):
        if node is None:
            return True
        if not(min_val<node.data<max_val):
            return False
        return self.is_bst(node.left,min_val,node.data) and self.is_bst(node.right,node.data,max_val)
    
    #Function to check whether a Binary Tree is BST or not.
    def isBST(self, root):
        #code here
        return self.is_bst(root,float('-inf'),float('inf'))
        # prev= -math.inf
        # temp=root
        # while temp!=None:
        #     if temp.left==None:
        #         if prev>=temp.data:
        #             return False
        #         prev=temp.data
        #         temp=temp.right
        #     else:
        #         left=temp.left
        #         while left.right!=None and left.right!=temp:
        #             left=left.right
                    
        #         if left.right==None:
        #             left.right=temp
        #             temp=temp.left
        #         elif left.right==temp:
        #             left.right=None
        #             if prev>=temp.data:
        #                 return False
        #             prev=temp.data
        #             temp=temp.right
        # return True
        




#{ 
 # Driver Code Starts
#Initial Template for Python 3
from collections import deque


# Tree Node
class Node:

    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None


# Function to Build Tree
def buildTree(s):
    #Corner Case
    if (len(s) == 0 or s[0] == "N"):
        return None

    # Creating list of strings from input
    # string after spliting by space
    ip = list(map(str, s.split()))

    # Create the root of the tree
    root = Node(int(ip[0]))
    size = 0
    q = deque()

    # Push the root to the queue
    q.append(root)
    size = size + 1

    # Starting from the second element
    i = 1
    while (size > 0 and i < len(ip)):
        # Get and remove the front of the queue
        currNode = q[0]
        q.popleft()
        size = size - 1

        # Get the current node's value from the string
        currVal = ip[i]

        # If the left child is not null
        if (currVal != "N"):

            # Create the left child for the current node
            currNode.left = Node(int(currVal))

            # Push it to the queue
            q.append(currNode.left)
            size = size + 1
        # For the right child
        i = i + 1
        if (i >= len(ip)):
            break
        currVal = ip[i]

        # If the right child is not null
        if (currVal != "N"):

            # Create the right child for the current node
            currNode.right = Node(int(currVal))

            # Push it to the queue
            q.append(currNode.right)
            size = size + 1
        i = i + 1
    return root


if __name__ == "__main__":
    t = int(input())
    for _ in range(0, t):
        s = input()
        root = buildTree(s)
        if Solution().isBST(root):
            print("true")
        else:
            print("false")

# } Driver Code Ends