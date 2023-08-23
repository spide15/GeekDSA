// Given a 2D grid of n*m of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters match in this direction (not in zig-zag form). The 8 directions are, horizontally left, horizontally right, vertically up, vertically down, and 4 diagonal directions.

// Note: The returning list should be lexicographically smallest. If the word can be found in multiple directions starting from the same coordinates, the list should contain the coordinates only once.
//{ Driver Code Starts
//Initial Template for Java

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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
         List<int[]> result = new ArrayList<>();
        //  int[][] resArr=new int[result.size()][2];
        int rows=grid.length;
        if(rows==0)
        return new int[0][0];
        int cols=grid[0].length;
        
        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==word.charAt(0)){
                    for(int dir =0;dir<8;dir++){
                        int x=i+dx[dir];
                        int y=j+dy[dir];
                        int k;
                        for(k=1;k<word.length();k++){
                             if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != word.charAt(k)) {
                                break;
                            }
                            x += dx[dir];
                            y += dy[dir];
                        }
                    
                     if (k == word.length()) {
                            result.add(new int[] {i, j});
                            break; // Break the loop if the word is found in this direction.
                     }
                    }
                }
            }
        }
        int[][] resArr=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            resArr[i]=result.get(i);
        }
        return resArr;
        
    }
}