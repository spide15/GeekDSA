// You are given a Binary Search Tree (BST) with n nodes, each node has a distinct value assigned to it. The goal is to flatten the tree such that, the left child of each element points to nothing (NULL), and the right child points to the next element in the sorted list of elements of the BST (look at the examples for clarity). You must accomplish this without using any extra storage, except for recursive calls, which are allowed.

// Note: If your BST does have a left child, then the system will print a -1 and will skip it, resulting in an incorrect solution.
//{ Driver Code Starts
    import java.util.*;

    class Node {
        int data;
        Node left, right;
    
        Node(int val) {
            data = val;
            left = right = null;
        }
    }
    
    public class GFG
    {
        public static void printList(Node head) {
            while (head != null) {
                if (head.left != null)
                    System.out.print("-1 ");
                System.out.print(head.data + " ");
                head = head.right;
            }
            System.out.println();
        }
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            sc.nextLine(); // Consume newline
            while (t-- > 0) {
                String str = sc.nextLine();
                Node root = buildTree(str);
                Solution ob = new Solution();
                Node ans = ob.flattenBST(root);
                printList(ans);
            }
            sc.close();
        }
    
        private static Node buildTree(String str) {
            if (str.length() == 0 || str.charAt(0) == 'N')
                return null;
    
            String[] ip = str.split("\\s+");
            int index = 0;
    
            Node root = new Node(Integer.parseInt(ip[index++]));
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
    
            while (!queue.isEmpty() && index < ip.length) {
                Node currNode = queue.poll();
    
                String currVal = ip[index++];
                if (!currVal.equals("N")) {
                    currNode.left = new Node(Integer.parseInt(currVal));
                    queue.add(currNode.left);
                }
    
                if (index >= ip.length)
                    break;
                currVal = ip[index++];
                if (!currVal.equals("N")) {
                    currNode.right = new Node(Integer.parseInt(currVal));
                    queue.add(currNode.right);
                }
            }
    
            return root;
        }
    }
    
    // } Driver Code Ends
    
    
    //User function Template for Java
    class Solution {
        void inOrder(Node root,List<Integer> in){
            if(root!=null){
                inOrder(root.left,in);
                in.add(root.data);
                inOrder(root.right,in);
            }
        }
        public Node flattenBST(Node root) {
            // Code here
            List<Integer> in=new ArrayList<>();
            inOrder(root,in);
            
            Node head=new Node(in.get(0));
            Node p=head;
            
            for(int i=1;i<in.size();i++){
                p.right=new Node(in.get(i));
                p.left=null;
                p=p.right;
            }
            return head;
        }
    }
    