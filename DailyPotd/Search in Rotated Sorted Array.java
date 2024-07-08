// Given a sorted (in ascending order) and rotated array arr of distinct elements which may be rotated at some point and given an element key, the task is to find the index of the given element key in the array arr. The whole array arr is given as the range to search.

// Rotation shifts elements of the array by a certain number of positions, with elements that fall off one end reappearing at the other end.

// Note:- 0-based indexing is followed & returns -1 if the key is not present.
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int[] arr, int key) {
        // Complete this function
         int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == key) {
                return mid;
            }
            
            // Check if the left half is sorted
            if (arr[left] <= arr[mid]) {
                // If the key is in the range of the left half
                if (arr[left] <= key && key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // The right half is sorted
                // If the key is in the range of the right half
                if (arr[mid] < key && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1; // key not found
    }
}