// Given a matrix of size N x N. Print the elements of the matrix in the snake like pattern depicted below.
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
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.snakePattern(matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
        // code here 
        ArrayList<Integer> ans =new ArrayList<>();
        int width=matrix[0].length;
        int height=matrix.length;
        
        if(height==0){
            return ans;
        }
        for(int i=0;i<height;i++){
            boolean Lr=(i%2==0);
            if(Lr){
                for(int j=0;j<width;j++){
                    ans.add(matrix[i][j]);
                }
            }else{
                for(int j=width-1;j>=0;j--){
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}