// Given a square matrix mat[][] of n*n size, the task is to determine the diagonal pattern which is a linear arrangement of the elements of the matrix as depicted in the following example:
//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    class GFG
    {
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                int n = Integer.parseInt(br.readLine().trim());
                int[][] mat = new int[n][n];
                String[] S = br.readLine().trim().split(" ");
                int i = 0;
                int j = 0;
                for(int k = 0; k < S.length; k++){
                    mat[i][j] = Integer.parseInt(S[k]);
                    j++;
                    if(j == n){
                        i++;
                        j = 0;
                    }
                }
                Solution obj = new Solution();
                int[] ans = obj.matrixDiagonally(mat);
                for(int it = 0; it < ans.length; it++){
                    System.out.print(ans[it] + " ");
                }
                System.out.println();
            }
        }
    }
    
    // } Driver Code Ends
    
    
    class Solution {
        public int[] matrixDiagonally(int[][] mat) {
            int n=mat.length;
            int[] result=new int[n*n];
            int row=0,col=0;
            int index=0;
            boolean goingUp=true;
            
            while(index<n*n){
                result[index++]=mat[row][col];
                if(goingUp){
                    if(col==n-1){
                        row++;
                        goingUp=false;
                    }else if(row==0){
                        col++;
                        goingUp=false;
                    }else{
                        row--;
                        col++;
                    }
                }else{
                    if(row==n-1){
                        col++;
                        goingUp=true;
                    }else if(col==0){
                        row++;
                        goingUp=true;
                    }else{
                        row++;
                        col--;
                    }
                }
            }
            return result;
        }
    }