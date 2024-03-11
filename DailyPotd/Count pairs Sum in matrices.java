// Given two sorted matrices mat1 and mat2 of size n x n of elements. Each matrix contains numbers arranged in strictly ascending order, with each row sorted from left to right, and the last element of a row being smaller than the first element of the next row. You're given a target value, x, your task is to find and count all pairs {a, b} such that a is from mat1 and b is from mat2 where sum of a and b is equal to x.
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int ans=0;
        int i=0,j=0;//mat1
        int a=n-1,b=n-1;//mat 2
        while(i<n && a>=0){
            if(mat1[i][j]+mat2[a][b]==x){
                ans++;
                if(j==n-1){
                    i++;
                    j=0;
                }else{
                    j++;
                }
                if(b==0){
                    a--;
                    b=n-1;
                }else{
                    b--;
                }
            }else if(mat1[i][j]+mat2[a][b]<x){
                if(j==n-1){
                    i++;
                    j=0;
                }else{
                    j++;
                }
            }else{
                if(b==0){
                    a--;
                    b=n-1;
                }else{
                    b--;
                }
            }
        }
        return ans;
        
    }
}