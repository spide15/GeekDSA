// Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
// Note: Unlike 0/1 knapsack, you are allowed to break the item here.
//{ Driver Code Starts
    import java.io.*;
    import java.lang.*;
    import java.util.*;
    
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
    
    class GfG {
        
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while(t-->0){
                String inputLine[] = br.readLine().trim().split(" ");
                int n = Integer.parseInt(inputLine[0]);
                int w = Integer.parseInt(inputLine[1]);
                Item[] arr = new Item[n];
                inputLine = br.readLine().trim().split(" ");
                for(int i=0, k=0; i<n; i++){
                    arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
                }
                System.out.println(String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
            }
        }
    }
    // } Driver Code Ends
    
    
    /*
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
    */
    
    class Solution
    {
        //Function to get the maximum total value in the knapsack.
        double fractionalKnapsack(int W, Item arr[], int n) 
        {
            // Your code here
            Arrays.sort(arr,(a,b)->{
                return 
                Double.compare((double)b.value/(double)b.weight,(double)a.value/(double)a.weight);
            });
            double ans=0;
            for(int i=0;i<n && W>0;i++){
                if(W>=arr[i].weight){
                    ans+=arr[i].value;
                    W-=arr[i].weight;
                }
                else{
                    ans+=
                    ((double)arr[i].value/(double)arr[i].weight)*W;
                    break;
                }
            }
            return ans;
            
        }
    }