# You are given a binary tree and you need to remove all the half nodes (which have only one child). Return the root node of the modified tree after removing all the half-nodes.

# Note: The output will be judged by the inorder traversal of the resultant tree, inside the driver code.
class Solution:
    def RemoveHalfNodes(self, node):
        #code here
        if node==None or (node.left==None and node.right==None):
            return node
        node.left=self.RemoveHalfNodes(node.left)
        node.right=self.RemoveHalfNodes(node.right)
        if node.left==None and node.right!=None:
            return node.right
        elif node.right==None and node.left!=None:
            return node.left
        return node



#{ 
 # Driver Code Starts
class Node:

    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def buildTree(s):
    if len(s) == 0 or s[0] == 'N':
        return None

    ip = s.split()
    root = Node(int(ip[0]))

    queue = []
    queue.append(root)

    i = 1
    while len(queue) > 0 and i < len(ip):
        currNode = queue.pop(0)
        currVal = ip[i]

        if currVal != 'N':
            currNode.left = Node(int(currVal))
            queue.append(currNode.left)

        i += 1
        if i >= len(ip):
            break

        currVal = ip[i]

        if currVal != 'N':
            currNode.right = Node(int(currVal))
            queue.append(currNode.right)

        i += 1

    return root


def printInorder(root):
    if root is None:
        return

    printInorder(root.left)
    print(root.data, end=' ')
    printInorder(root.right)


if __name__ == "__main__":
    import sys
    input = sys.stdin.read
    data = input().splitlines()

    t = int(data[0])
    index = 1

    while t > 0:
        s = data[index]
        root = buildTree(s)
        solution = Solution()
        fresh = solution.RemoveHalfNodes(root)
        printInorder(fresh)
        print()
        t -= 1
        index += 1

# } Driver Code Ends