// Given a sorted array of unique elements in increasing order, arr[] of n integers, and a value x. Find the K closest elements to x in arr[].
// Keep the following points in mind:

// If x is present in the array, then it need not be considered.
// If two elements have the same difference as x, the greater element is prioritized.
// If sufficient elements are not present on the right side, take elements from the left and vice versa.
int[] printKClosest(int[] arr, int n, int k, int x) {
    // code here
    int ans[] = new int[k];
    int ind = findInd(arr, n, x);
    int i=ind, j=ind;
    while(i>=0 && arr[i]==x) i--;
    while(j<n && arr[j]==x) j++;
    int c=0;
    if(i==j){
        ans[0] = arr[i];
        i--;
        j++;
        c++;
    }
    while(i>=0 && j<n && c<k){
        if(Math.abs(arr[i]-x) < Math.abs(arr[j]-x)){
            ans[c] = arr[i];
            i--;
        }else{
            ans[c] = arr[j];
            j++;
        }
        c++;
    }
    while(i>=0 && c<k){
        ans[c] = arr[i];
        c++;
        i--;
    }
    while(j<n && c<k){
        ans[c] = arr[j];
        c++;
        j++;
    }
    return ans;
}
public static int findInd(int arr[], int n, int x){
    int l=0,h=n-1;
    while(l<h && h-l>1){
        int m = (l+h)/2;
        if(arr[m]==x) return m;
        if(arr[m]>x) h=m;
        if(arr[m]<x) l=m;
    }
    return Math.abs(arr[l]-x)<Math.abs(arr[h]-x)?l:h;