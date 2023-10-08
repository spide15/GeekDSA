// Weekly Coding Contest

// banner
// Given a linked list sorted in ascending order and an integer called data, insert data in the linked list such that the list remains sorted.
//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution g = new Solution();
            head = g.sortedInsert(head,k);
            
            printList(head); 
            t--;
        }
    } 
} 

// } Driver Code Ends


/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head, int data) {
        // Add your code here.
        Node newNode = new Node(data);

        // If the linked list is empty or the new node data is smaller than the head, insert at the beginning
        if (head == null || data <= head.data) {
            newNode.next = head;
            return newNode;
        }

        // Traverse the linked list to find the correct position to insert the new node
        Node current = head;
        Node prev = null;

        while (current != null && current.data < data) {
            prev = current;
            current = current.next;
        }

        // Insert the new node between the previous node and the current node
        if(prev!=null){
        prev.next = newNode;
        newNode.next = current;
        }

        return head;
       
    }
}