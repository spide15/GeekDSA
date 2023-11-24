// Given a positive integer N, return the Nth row of pascal's triangle.
// Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.
// The elements can be large so return it modulo 109 + 7.
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static final long MOD = 1000000007; 
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        
        ArrayList<Long> currentRow = new ArrayList<>();
        currentRow.add(1L); // First element is always 1

        // Generating rows one by one up to the nth row
        for (int i = 1; i < n; i++) {
            ArrayList<Long> nextRow = new ArrayList<>();
            nextRow.add(1L); // First element of each row is 1

            // Calculate each value for the next row except the first and last element
            for (int j = 1; j < i; j++) {
                long newValue = (currentRow.get(j - 1) + currentRow.get(j)) % MOD;
                nextRow.add(newValue);
            }

            nextRow.add(1L); // Last element of each row is 1
            currentRow = nextRow; // Update current row to the next row for the next iteration
        }

        return currentRow;
        
    }
}