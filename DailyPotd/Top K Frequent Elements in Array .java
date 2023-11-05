// Given a non-empty array nums[] of integers of length N, find the top k elements which have the highest frequency in the array. If two numbers have same frequencies, then the larger number should be given more preference.
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Pair{
    int key;
    int val;
    public Pair(int key,int val){
        this.key = key;
        this.val = val;
    }
}
class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // PriorityQueue<Pair> pQueue=new PriorityQueue<Pair>(
        //     new Comparator<Pair>(){
        //         public int compare(Pair a,Pair b){
        //             if(a.val<b.val) return 1;
        //             else if(a.val>b.val) return -1;
        //             else{
        //                 if(a.key<b.key) return 1;
        //                 else if(a.key>b.key) return -1;
        //                 else return 0;
        //             }
        //         }
        //     } 
        // );
          PriorityQueue<Pair> pQueue = new PriorityQueue<Pair>(
                new Comparator<Pair>() {
                    public int compare(Pair a,Pair b){
                        if(a.val < b.val) return 1;
                        else if(a.val > b.val) return -1;
                        else if(a.val == b.val){
                            if(a.key < b.key) return 1;
                            else if(a.key > b.key) return -1;
                            else return 0;
                        }else return 0;
                    }  
                });
        for(Map.Entry<Integer,Integer> set:map.entrySet()){
            pQueue.add(new Pair(set.getKey(),set.getValue()));
        }
        int[] ans=new int[k];
        
        for(int i=0;i<k;i++){
            ans[i]=pQueue.poll().key;
        }
        return ans;
        
        
    }
}