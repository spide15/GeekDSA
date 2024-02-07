// Given a binary tree with n nodes and two node values, a and b, your task is to find the minimum distance between them. The given two nodes are guaranteed to be in the binary tree and all node values are unique.
//{ Driver Code Starts
    import java.util.LinkedList;
    import java.util.Queue;
    import java.io.*;
    import java.util.*;
    
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    class Main {
        static Node buildTree(String str) {
    
            if (str.length() == 0 || str.charAt(0) == 'N') {
                return null;
            }
    
            String ip[] = str.split(" ");
            // Create the root of the tree
            Node root = new Node(Integer.parseInt(ip[0]));
            // Push the root to the queue
    
            Queue<Node> queue = new LinkedList<>();
    
            queue.add(root);
            // Starting from the second element
    
            int i = 1;
            while (queue.size() > 0 && i < ip.length) {
    
                // Get and remove the front of the queue
                Node currNode = queue.peek();
                queue.remove();
    
                // Get the current node's value from the string
                String currVal = ip[i];
    
                // If the left child is not null
                if (!currVal.equals("N")) {
    
                    // Create the left child for the current node
                    currNode.left = new Node(Integer.parseInt(currVal));
                    // Push it to the queue
                    queue.add(currNode.left);
                }
    
                // For the right child
                i++;
                if (i >= ip.length) break;
    
                currVal = ip[i];
    
                // If the right child is not null
                if (!currVal.equals("N")) {
    
                    // Create the right child for the current node
                    currNode.right = new Node(Integer.parseInt(currVal));
    
                    // Push it to the queue
                    queue.add(currNode.right);
                }
                i++;
            }
    
            return root;
        }
    
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
    
            int t = Integer.parseInt(br.readLine().trim());
    
            while (t-- > 0) {
                String s = br.readLine().trim();
                Node root = buildTree(s);
                String[] ab = br.readLine().trim().split(" ");
                int a = Integer.parseInt(ab[0]);
                int b = Integer.parseInt(ab[1]);
    
                GfG g = new GfG();
                System.out.println(g.findDist(root, a, b));
            }
        }
    }
    
    
    // } Driver Code Ends
    
    
    // FUNCTION CODE
    /* A Binary Tree node
    class Node
    {
        int data;
        Node left, right;
       Node(int item)    {
            data = item;
            left = right = null;
        }
    } */
    
    /* Should return minimum distance between a and b
       in a tree with given root*/
    class GfG {
        public Node lowestCommonAncestor(Node root, int p, int q) {
            if (root == null || root.data == p || root.data == q) return root;
    
            Node left = lowestCommonAncestor(root.left, p, q);
            Node right = lowestCommonAncestor(root.right, p, q);
            
            if (left != null && right != null) return root;
            
            return left != null ? left : right;
        }
        public int distanceFromRoot(Node root,int x){
            if(root==null)
            return -1;
            
            if (root.data == x) return 0;
            
            int leftDist = distanceFromRoot(root.left, x);
            int rightDist = distanceFromRoot(root.right, x);
            
            if (leftDist != -1) return leftDist + 1;
            if (rightDist != -1) return rightDist + 1;
            
            return -1;
        }
        int findDist(Node root, int a, int b) {
            // Your code here
            Node lca=lowestCommonAncestor(root,a,b);
            int distA=distanceFromRoot(lca,a);
            int distB=distanceFromRoot(lca,b);
            return distA+distB;
        }
    }