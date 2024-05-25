// You have n stacks of books. Each stack of books has some nonzero height arr[i] equal to the number of books on that stack ( considering all the books are identical and each book has a height of 1 unit ). In one move, you can select any number of consecutive stacks of books such that the height of each selected stack of books arr[i] <= k. Once such a sequence of stacks is chosen, You can collect any number of books from the chosen sequence of stacks.
// What is the maximum number of books that you can collect this way?
//{ Driver Code Starts
    import java.util.*;

    class GFG {
        public static void main(String args[]) throws Exception {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
    
            while (T > 0) {
                int N = sc.nextInt();
                int k = sc.nextInt();
                int ar[] = new int[N];
                //	int count = 0;
                for (int i = 0; i < N; i++) ar[i] = sc.nextInt();
    
                System.out.println(new Solution().max_Books(ar, N, k));
                T--;
            }
        }
    }
    // } Driver Code Ends
    
    
    
    class Solution {
        long max_Books(int arr[], int n, int k) {
            // Your code here
             long curr=0;
            long maxi=0;
            
            for(int i=0;i<n;i++){
                if(arr[i]<=k){
                    curr += arr[i];
                    maxi = Math.max(maxi,curr);
                }
                else{
                    curr=0;
                }
            }
            return maxi;
        }
    }