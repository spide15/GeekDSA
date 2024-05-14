// You are a hiker preparing for an upcoming hike. You are given heights[][], a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find the route with minimum effort.

// Note: A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class IntMatrix {
        public static int[][] input(BufferedReader br, int n, int m) throws IOException {
            int[][] mat = new int[n][];
    
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().trim().split(" ");
                mat[i] = new int[s.length];
                for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
            }
    
            return mat;
        }
    
        public static void print(int[][] m) {
            for (var a : m) {
                for (int e : a) System.out.print(e + " ");
                System.out.println();
            }
        }
    
        public static void print(ArrayList<ArrayList<Integer>> m) {
            for (var a : m) {
                for (int e : a) System.out.print(e + " ");
                System.out.println();
            }
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
    
                int rows;
                rows = Integer.parseInt(br.readLine());
    
                int columns;
                columns = Integer.parseInt(br.readLine());
    
                int[][] heights = IntMatrix.input(br, rows, columns);
    
                Solution obj = new Solution();
                int res = obj.MinimumEffort(rows, columns, heights);
    
                System.out.println(res);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    
    class Solution {
          public static int MinimumEffort(int rows, int columns, int[][] heights) {
            // code here
             int[][] effort = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                Arrays.fill(effort[i], Integer.MAX_VALUE);
            }
            
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            pq.offer(new int[]{0, 0, 0}); // (row, col, effort)
            
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int row = curr[0];
                int col = curr[1];
                int currEffort = curr[2];
                
                if (row == rows - 1 && col == columns - 1)
                    return currEffort;
                
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns) {
                        int newEffort = Math.max(currEffort, Math.abs(heights[newRow][newCol] - heights[row][col]));
                        if (newEffort < effort[newRow][newCol]) {
                            effort[newRow][newCol] = newEffort;
                            pq.offer(new int[]{newRow, newCol, newEffort});
                        }
                    }
                }
            }
            
            return -1; // Unreachable
        }
    }
    