// Given two integers s and d. The task is to find the smallest number such that the sum of its digits is s and the number of digits in the number are d. Return a string that is the smallest possible number. If it is not possible then return -1
//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        if((s<1 && d>1) || d*9<s)
        return "-1";
        
        int[] ans=new int[d];
        for(int i=d-1;i>=0;i--){
            if(s>9){
                ans[i]=9;
                s-=9;
            }
            else{
                if(i==0)
                ans[i]=s;
                else{
                    ans[i]=s-1;
                    s=1;
                }
            }
        }
        if(s==1)
        ans[0]=s;
        StringBuilder str=new StringBuilder();
        for(int i:ans){
            str.append(i);
        }
        
        return str.toString();
    }
}
