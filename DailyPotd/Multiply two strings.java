// Given two numbers as strings s1 and s2. Calculate their Product.

// Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers. There can be zeros in the begining of the numbers.
//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
       int sign=1;
       if(s1.charAt(0)=='-'){
           sign*=-1;
           s1=s1.substring(1);
       }
       if(s2.charAt(0)=='-'){
           sign*=-1;
           s2=s2.substring(1);
       }
       int n1=s1.length();
       int n2=s2.length();
       int[] result=new int[n1+n2];
       
       for(int i=n1-1;i>=0;i--){
           int num1=s1.charAt(i)-'0';
           for(int j=n2-1;j>=0;j--){
               int num2=s2.charAt(j)-'0';
               int prod=num1*num2;
               int sum=prod+result[i+j+1];
               result[i+j+1]=sum%10;
               result[i+j]+=sum/10;
           }
       }
       StringBuilder sb=new StringBuilder();
       for(int num:result){
           sb.append(num);
       }
       while(sb.length()>0 && sb.charAt(0)=='0'){
           sb.deleteCharAt(0);
       }
        return sb.length() == 0 ? "0" : (sign == -1 ? "-" : "") + sb.toString();
        
    }
}
