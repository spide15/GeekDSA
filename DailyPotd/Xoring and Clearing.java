// You are given an array arr[] of size n. You need to do the following:

// You need to calculate the bitwise XOR of each element in the array with its corresponding index (indices start from 0).
// After step1, print the array.
// Now, set all the elements of arr[] to zero.
// Now, print arr[].
//{ Driver Code Starts
    import java.util.*;

    public class GFG {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                Solution obj = new Solution();
                obj.xor1ToN(n, arr);
                obj.printArr(n, arr);
                obj.setToZero(n, arr);
                obj.printArr(n, arr);
            }
            sc.close();
        }
    }
    
    // } Driver Code Ends
    
    
    // User function Template for Java
    class Solution {
        public void printArr(int n, int arr[]) {
            // code here
            for(int i : arr)System.out.print(i+" ");
            System.out.println();
        }
    
        public void setToZero(int n, int arr[]) {
            // code here
            for(int i = 0; i < n ; i++){
                arr[i] = 0;
            }
        }
    
        public void xor1ToN(int n, int arr[]) {
            // code here
            for(int i = 0; i < n ; i++){
                arr[i] ^= i;
            }
        }
    }