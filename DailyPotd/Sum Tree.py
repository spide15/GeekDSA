# Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return true if it is a Sum Tree otherwise, return false.

# A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree. An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.
#{ 
 # Driver Code Starts
#Initial Template for Python 3
# 
# } Driver Code Ends
#User function Template for python3

'''
class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
'''
class Solution:
    def is_sum_tree(self, node):
        # Helper function that returns a tuple (is_sum_tree, sum)
        def check_sum_tree(node):
            if node is None:
                return True, 0
            
            if node.left is None and node.right is None:
                return True, node.data
            
            left_is_sum_tree, left_sum = check_sum_tree(node.left)
            right_is_sum_tree, right_sum = check_sum_tree(node.right)
            
            # Check if current node is sum tree
            current_is_sum_tree = (left_is_sum_tree and right_is_sum_tree and 
                                   node.data == left_sum + right_sum)
            
            # Return whether this subtree is a sum tree and the sum of this subtree
            return current_is_sum_tree, left_sum + right_sum + node.data
        
        # Only need the boolean result from the helper function
        is_sum_tree, _ = check_sum_tree(node)
        return is_sum_tree

#{ 
 # Driver Code Starts.
class Node:

    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


# Utility function to create a new Tree Node
def new_node(val):
    return Node(val)


# Function to Build Tree
def build_tree(s):
    # Corner Case
    if not s or s[0] == 'N':
        return None

    # Creating list of strings from input string after splitting by space
    ip = s.split()

    # Create the root of the tree
    root = new_node(int(ip[0]))

    # Push the root to the queue
    queue = []
    queue.append(root)

    # Starting from the second element
    i = 1
    while queue and i < len(ip):
        # Get and remove the front of the queue
        curr_node = queue.pop(0)

        # Get the current node's value from the string
        curr_val = ip[i]

        # If the left child is not null
        if curr_val != "N":
            # Create the left child for the current node
            curr_node.left = new_node(int(curr_val))

            # Push it to the queue
            queue.append(curr_node.left)

        # For the right child
        i += 1
        if i >= len(ip):
            break
        curr_val = ip[i]

        # If the right child is not null
        if curr_val != "N":
            # Create the right child for the current node
            curr_node.right = new_node(int(curr_val))

            # Push it to the queue
            queue.append(curr_node.right)
        i += 1

    return root


# Driver code
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        s = input()
        root = build_tree(s)
        ob = Solution()
        if ob.is_sum_tree(root):
            print("true")
        else:
            print("false")

# } Driver Code Ends