// Given two strings, one is a text string, txt and other is a pattern string, pat. The task is to print the indexes of all the occurences of pattern string in the text string. Use one-based indexing while returing the indices. 
// Note: Return an empty list incase of no occurences of pattern. Driver will print -1 in this case.
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        
        // ArrayList<Integer> al=new ArrayList<Integer>();
        // int c=0;
        // for(int i=0;i<=txt.length()-pat.length();i++){
        //     if(pat.equals(txt.substring(i,i+pat.length()))){
        //         c++;
        //         al.add(i+1);
        //     }
        // }
        
        // if(c==0){
        //     al.add(-1);
        //     return al;
        // }else{
        //     return al;
        // }
        ArrayList<Integer> list=new ArrayList<>();
        if(txt.indexOf(pat)==-1){
            list.add(-1);
            return list;
        }
        int index=txt.indexOf(pat);
        list.add(index+1);
        
        while(index!=-1){
            index=txt.indexOf(pat,index+1);
            
            if(index!=-1)
            list.add(index+1);
        }
        return list;
        
        
    }
}