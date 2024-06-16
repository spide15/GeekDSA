// Given a number n, find out if n can be expressed as a+b, where both a and b are prime numbers. If such a pair exists, return the values of a and b, otherwise return [-1,-1] as an array of size 2.
// Note: If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, and a < c then  [a, b] is considered as our answer.
//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends




class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
        // code here
        boolean prime[]=new boolean[n];
        Arrays.fill(prime,true);
        
        for(int i=2;i<=n/2;i++)
        {
            if(prime[i])
            {   
                int k=i+i;
                while(k<n)
                {
                    prime[k]=false;
                    k=k+i;
                }
            }
        }
        ArrayList<Integer>ans=new ArrayList<Integer>();
        for(int i=2;i<=n/2;i++)
        {
            if(prime[i] && prime[n-i])
            {
                ans.add(i);
                ans.add(n-i);
                break;
            }
        }
        if(ans.size()==0)
        return new ArrayList<>(Arrays.asList(-1,-1));
        return ans;
    }
}
