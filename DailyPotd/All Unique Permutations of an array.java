// Given an array arr[] of length n. Find all possible unique permutations of the array in sorted order. A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.
//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        list.clear();
        Collections.sort(arr);
        ArrayList<Integer> ll=new ArrayList<>();
        backtrack(ll,arr,new boolean[n]);
        return list;
    }
    
    public static void backtrack(ArrayList<Integer> ll,ArrayList<Integer> arr,boolean[] used){
        if(ll.size()==arr.size()){
            list.add(new ArrayList<>(ll));
            return;
        }
        
        for(int i=0;i<arr.size();i++){
            if(used[i] || (i>0 && arr.get(i).equals(arr.get(i-1)) && !used[i-1])){
                continue;
            }
            ll.add(arr.get(i));
            used[i]=true;
            backtrack(ll,arr,used);
            used[i]=false;
            ll.remove(ll.size()-1);
        }
    }
};