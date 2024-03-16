// ou are given a node del_node of a Singly Linked List where you have to delete a value of the given node from the linked list but you are not given the head of the list.

// By deleting the node value, we do not mean removing it from memory. We mean:

// The value of the given node should not exist in the linked list.
// The number of nodes in the linked list should decrease by one.
// All the values before & after the del_node node should be in the same order.
// Note:

// Multiple nodes can have the same values as the del_node, but you must only remove the node whose pointer del_node is given to you.
// It is guaranteed that there exists a node with a value equal to the del_node value and it will not be the last node of the linked list.
//{ Driver Code Starts
    import java.util.*;

    class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    
    class Delete_Node
    {
        Node head;
        Node tail;
        
        void printList(Node head)
        {
            Node tnode = head;
            while(tnode != null)
            {
                System.out.print(tnode.data+ " ");
                tnode = tnode.next;
            }
            System.out.println();
        }
        
        void addToTheLast(Node node)
        {
            
            if(head == null)
            {
                head = node;
                tail = node;
            }
            else
            {
                tail.next = node;
                tail = node;
            }
        }
        
        Node search_Node(Node head, int k)
        {
            Node current = head;
            while(current != null)
            {
                if(current.data == k)
                    break;
                current = current.next;
            }
        return current;
        }
        
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            
            int t = sc.nextInt();
            while(t>0)
            {
                int n = sc.nextInt();
                Delete_Node llist = new Delete_Node();
                //int n=Integer.parseInt(br.readLine());
                int a1=sc.nextInt();
                Node head= new Node(a1);
                llist.addToTheLast(head);
                for (int i = 1; i < n; i++) 
                {
                    int a = sc.nextInt(); 
                    llist.addToTheLast(new Node(a));
                }
                
                int k = sc.nextInt();
                Node del_node = llist.search_Node(llist.head,k);
                
                Solution g = new Solution();
                if(del_node != null && del_node.next != null)
                {
                    g.deleteNode(del_node);
                }
                llist.printList(llist.head);
            t--;
            }
        }
    }
    
    
    
    // } Driver Code Ends
    
    
    /*
    class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    */
    
    //Function to delete a node without any reference to head pointer.
    class Solution
    {
        void deleteNode(Node del_node)
        {
             // Your code here
             if(del_node.next==null){
                 del_node=null;
             }else{
                 del_node.data=del_node.next.data;
                 del_node.next=del_node.next.next;
             }
        }
    }
    
    