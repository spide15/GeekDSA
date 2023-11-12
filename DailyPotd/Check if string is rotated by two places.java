// GfG Weekly + You = Perfect Sunday Evenings!
// Register for free now

// banner
// Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating (in any direction) string 'a' by exactly 2 places.
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
        // Your code here
        if(str1.length()!=str2.length())
        return false;
        
        int n=str1.length();
        if(n<=2)
        return str1.equals(str2);
        
        String clockwise=str1.substring(2,n)+str1.substring(0,2);
        if(clockwise.equals(str2))
        return true;
        
        String anticlockwise=str1.substring(n-2,n)+str1.substring(0,n-2);
        return anticlockwise.equals(str2);
    }
    
}