// Given two integer array A and B of size N each.
// A sum combination is made by adding one element from array A and another element of array B.
// Return the maximum K valid sum combinations from all the possible sum combinations.

// Note : Output array must be sorted in non-increasing order.
//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Pair{
    int sum;
    int indexA;
    int indexB;
    Pair(int sum,int indexA,int indexB){
        this.sum=sum;
        this.indexA=indexA;
        this.indexB=indexB;
    }
}
class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(b.sum-a.sum));
        pq.offer(new Pair(A[N-1]+B[N-1],N-1,N-1));
        HashSet<String> visited=new HashSet<>();
        ArrayList<Integer>  result=new ArrayList<>();
        while (K > 0) {
            Pair current = pq.poll();
            int sum = current.sum;
            int indexA = current.indexA;
            int indexB = current.indexB;

            result.add(sum);

            if (indexA > 0 && !visited.contains((indexA - 1) + "-" + indexB)) {
                pq.offer(new Pair(A[indexA - 1] + B[indexB], indexA - 1, indexB));
                visited.add((indexA - 1) + "-" + indexB);
            }

            if (indexB > 0 && !visited.contains(indexA + "-" + (indexB - 1))) {
                pq.offer(new Pair(A[indexA] + B[indexB - 1], indexA, indexB - 1));
                visited.add(indexA + "-" + (indexB - 1));
            }

            K--;
        }

        return result;
    }
}
