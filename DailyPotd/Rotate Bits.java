// Given an integer N and an integer D, rotate the binary representation of the integer N by D digits to the left as well as right and return the results in their decimal representation after each of the rotation.
// Note: Integer N is stored using 16 bits. i.e. 12 will be stored as 0000000000001100.

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> rotate(int N, int D)
    {
        // your code here
        ArrayList<Integer> list=new ArrayList<>();
        String binaryN = String.format("%16s", Integer.toBinaryString(N)).replace(' ', '0');

        D=D%16;
        String left1=binaryN.substring(0,D);
        String right1=binaryN.substring(D);
        
        list.add(Integer.parseInt(right1+left1,2));
        
        String left2=binaryN.substring(0,binaryN.length()-D);
        String right2=binaryN.substring(binaryN.length()-D);
        
        list.add(Integer.parseInt(right2+left2,2));
        return list;
    }
}
