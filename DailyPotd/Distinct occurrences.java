// Given two strings s and t of length n and m respectively. Find the count of distinct occurrences of t in s as a sub-sequence modulo 109 + 7.
//{ Driver Code Starts
    import java.util.*;

    class Distinct_Occurrences
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            sc.nextLine();
            while(t>0)
            {
                String line = sc.nextLine();
                String S = line.split(" ")[0];
                String T = line.split(" ")[1];
                
                Solution ob = new Solution();
                System.out.println(ob.subsequenceCount(S,T));
                t--;
            }
        }
    }
    // } Driver Code Ends
    
    
    /*You are required to complete this method*/
    
    class Solution
    {
        int mod=(int)1e9+7;
        int dp[][]=null;
        int helper(String s,String t,int i,int j){
            if(j==t.length())
            return 1;
            
            if(i==s.length())
            return 0;
            
            if(dp[i][j]!=-1)
            return dp[i][j];
            
            int incl=0;
            
            if(s.charAt(i)==t.charAt(j))
            incl=helper(s,t,i+1,j+1);
            
            int excl=helper(s,t,i+1,j);
            
            return dp[i][j]=(incl+excl)%mod;
        }
        int  subsequenceCount(String s, String t)
        {
        // Your code here	
        dp=new int[s.length()][t.length()];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        return helper(s,t,0,0);
        }
    }