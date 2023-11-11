// Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.

// If the characters in str1 can be changed to get str2, then two strings, str1 and str2, are isomorphic. A character must be completely swapped out for another character while maintaining the order of the characters. A character may map to itself, but no two characters may map to the same character.
//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here
        if(str1.length()!=str2.length()){
            return false;
        }
        Map<Character,Character> charMapstr1=new HashMap<>();
        Map<Character,Character> charMapstr2=new HashMap<>();
        for(int i=0;i<str1.length();i++){
            char char1=str1.charAt(i);
            char char2=str2.charAt(i);
            if(charMapstr1.containsKey(char1)){
                if(charMapstr1.get(char1)!=char2){
                    return false;
                }
            }else{
                charMapstr1.put(char1,char2);
            }
            if(charMapstr2.containsKey(char2)){
                if(charMapstr2.get(char2)!=char1){
                    return false;
                }
            }else{
                charMapstr2.put(char2,char1);
            }
        }
        return true;
        
    }
}