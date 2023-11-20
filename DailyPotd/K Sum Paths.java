// Given a binary tree and an integer K. Find the number of paths in the tree which have their sum equal to K.
// A path may start from any node and end at any node in the downward direction.
// Since the answer may be very large, compute it modulo 109+7
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            
            System.out.println(ob.sumK(root,k));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    private int count=0;
    public int sumK(Node root,int k)
    {
        // code here 
        count=0;
        HashMap<Integer,Integer> prefixSumMap=new HashMap<>();
        prefixSumMap.put(0,1);
        calculatePaths(root,0,k,prefixSumMap);
        return count;
    }
    private void calculatePaths(Node node,int currentSum,int k,HashMap<Integer,Integer> prefixSumMap){
        if(node==null){
            return;
        }
        currentSum+=node.data;
        if(prefixSumMap.containsKey(currentSum-k))
        count+=prefixSumMap.get(currentSum-k);
        
        prefixSumMap.put(currentSum,prefixSumMap.getOrDefault(currentSum,0)+1);
        
        calculatePaths(node.left,currentSum,k,prefixSumMap);
        calculatePaths(node.right,currentSum,k,prefixSumMap);
        
        prefixSumMap.put(currentSum,prefixSumMap.get(currentSum)-1);
    }
}