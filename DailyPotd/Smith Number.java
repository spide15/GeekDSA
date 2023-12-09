// Given a number n, the task is to find out whether this number is a Smith number or not. A Smith number is a composite number whose sum of digits is equal to the sum of digits of its prime factors
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.smithNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int smithNum(int n) {
        // code here
        int digit_sum=0;
        int store=n;
        while(n!=0){
            digit_sum+=n%10;
            n=n/10;
        }
        n=store;
        ArrayList<Integer> list =findPrimeFactor(n);
        n=store;
        if(isPrime(n)){
            return 0;
        }else{
            if(digit_sum==SumOfAllDigit_in_the_list(list)){
                return 1;
            }else{
                return 0;
            }
        }
    }
    public static ArrayList<Integer> findPrimeFactor(int n){
        ArrayList<Integer> list=new ArrayList<>();
        int i=2;
        while(n!=1){
            if(n%i==0){
                list.add(i);
                n=n/i;
            }else{
                i++;
            }
        }
        return list;
    }
    public static int SumOfAllDigit_in_the_list(ArrayList<Integer> list){
        int total_sum=0;
        for(int i=0;i<list.size();i++){
            int val=list.get(i);
            while(val!=0){
                total_sum+=val%10;
                val=val/10;
            }
        }
        return total_sum;
    }
    public static boolean isPrime(int n){
        int i=2;
        while(i<=Math.sqrt(n)){
            if(n%i==0){
                return false;
            }
            i++;
        }
        return true;
    }
};