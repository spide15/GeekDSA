// A Techfest is underway, and each participant is given a ticket with a unique number. Organizers decide to award prize points to everyone who has a ticket ID between a and b (inclusive). The points given to a participant with ticket number x will be the sum of powers of the prime factors of x.

// For instance, if points are to be awarded to a participant with ticket number 12, the amount of points given out will be equal to the sum of powers in the prime factorization of 12 (22 × 31), which will be 2 + 1 = 3.

// Given a and b, determine the sum of all the points that will be awarded to the participants with ticket numbers between a and b (inclusive).
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long primeFactors(long n){
        long sum=0;
        while(n%2==0){
            n/=2;
            sum++;
        }
        
        for(long i=3;i<=Math.sqrt(n);i+=2){
            while(n%i==0){
                n/=i;
                sum++;
            }
        }
        if(n>2){
            sum++;
        }
        return sum;
    }
    public static long sumOfPowers(long a, long b) {
        // code here
        long finalSum=0;
        for(long i=a;i<=b;i++){
            finalSum+=primeFactors(i);
        }
        return finalSum;
    }
}
        
