// Given an array a of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than once in the given array. Return the answer in ascending order. If no such element is found, return list containing [-1]
//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int a[], int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
    
    // Create a HashMap to store the frequency of each element
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    
    // Count the frequency of each element in the array
    for (int num : a) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    // Iterate through the HashMap and add elements with frequency > 1 to the result ArrayList
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
        if (entry.getValue() > 1) {
            result.add(entry.getKey());
        }
    }

    // Sort the result ArrayList
    result.sort(null);

    // If no duplicates were found, add -1 to the result
    if (result.isEmpty()) {
        result.add(-1);
    }

    return result;
    }
}
