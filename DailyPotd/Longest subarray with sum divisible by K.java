// Given an array arr containing N integers and a positive integer K, find the length of the longest sub array with sum of the elements divisible by the given value K.
//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        // Complete the function
       HashMap<Integer,Integer> remainderMap=new HashMap<>();
       int cumSum=0;
       int maxLength=0;
       
       for(int i=0;i<n;i++){
           cumSum+=a[i];
           int remainder=((cumSum%k)+k)%k;
           
           if(remainder==0){
               maxLength=i+1;
           }else{
               if(remainderMap.containsKey(remainder)){
                   maxLength=Math.max(maxLength,i-remainderMap.get(remainder));
               }else{
                   remainderMap.put(remainder,i);
               }
           }
       }
       return maxLength;
    }
 
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends