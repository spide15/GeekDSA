// Given a sorted array containing only 0s and 1s, find the transition point, i.e., the first index where 1 was observed, and before that, only 0 was observed.
//{ Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    int transitionPoint(int arr[], int n) {
        // code here
         int lowerBound = 0;
        int upperBound = n - 1;
        int transitionPoint = n;
        
        while(lowerBound <= upperBound) {
            int midIndex = lowerBound + (upperBound - lowerBound) / 2;
            
            if(arr[midIndex] == 1) {
                transitionPoint = Math.min(transitionPoint, midIndex);
                upperBound = midIndex - 1;
            }
            else {
                lowerBound = midIndex + 1;
            }
        }
        
        return transitionPoint == n ? -1 : transitionPoint;
    }
}