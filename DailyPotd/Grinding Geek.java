// GeeksforGeeks has introduced a special offer where you can enroll in any course, and if you manage to complete 90% of the course within 90 days, you will receive a refund of 90%.

// Geek was fascinated by this offer. This offer was valid for only n days, and each day a new course was available for purchase. Geek decided that if he bought a course on some day, he will complete that course on the same day itself and redeem floor[90% of cost of the course] amount back. Find the maximum number of courses that Geek can complete in those n days if he had total amount initially.

// Note: On any day, Geek can only buy the new course that was made available for purchase that day.
//{ Driver Code Starts
    import java.util.*;
    import java.io.*;
    
    public class GFG {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            while(t-- > 0)
            {
                int n = scanner.nextInt();
                int total = scanner.nextInt();
                int[] cost = new int[n];
                for (int i = 0; i < n; i++) {
                    cost[i] = scanner.nextInt();
                }
                Solution solution = new Solution();
                int result = solution.max_courses(n, total, cost);
                System.out.println(result);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    //User function Template for Java
    class Solution {
        int[][] dp;
        public int max_courses(int n, int total, int[] cost) {
            // code here
            dp=new int[n+1][total+1];
            // Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
            Arrays.stream(dp).forEach(arr -> Arrays.fill(arr,-1));
            return findMaxCourses(n,total,cost,0);
        }
        
        public int findMaxCourses(int n,int total,int[] cost,int currentIndex){
            if(total<=0 || currentIndex>=n){
                return 0;
            }else if(dp[currentIndex][total]!=-1){
                return dp[currentIndex][total];
            }
            
            int consider=0,notConsider=0;
            
            if(total>=cost[currentIndex]){
                int newTotal=(int)Math.floor(total-cost[currentIndex]*0.10);
                consider=1+findMaxCourses(n,newTotal,cost,currentIndex+1);
            }
            notConsider=findMaxCourses(n,total,cost,currentIndex+1);
            
            return dp[currentIndex][total]=Math.max(consider,notConsider);
        }
    }
    
    