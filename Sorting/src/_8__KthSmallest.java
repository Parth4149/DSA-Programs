
// Quick select algorithm
public class _8__KthSmallest {
    public static int lPartition(int[] arr, int l, int r){ // Lomuto Partition     // time : O(n)      space : O(1)
        int pivot = arr[r];   // take last element as pivot
        int i = l;
        // traverse the loop
        for(int j = l; j <= (r - 1); j++){  // NOTE : loop starting from the l not 0
            if(arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr,i, r);
        return i; // position of last element
    }
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * time complexity
     -> worst case : theta(n^2)
     -> average case : theta(n)
     */
    public static int kthSmallest(int[] arr, int k){
        if(k < 1 || k > arr.length){
            return -1;
        }
        int l = 0, r = arr.length - 1;
        while(l <= r){      // Like Binary search but here this takes O(n) time
            // it returns index of pivot and (smaller elements move left side and larger element move right side)
            int p = lPartition(arr, l, r);  //  Lomuto partition

            // here we compare (k-1) becoz index starting from 0
            if((k - 1) == p){
//                System.out.println(l+" "+r);
                return arr[p];
            }
            else if((k - 1) < p){  // move left
                r = p - 1;
            }
            else{
                l = p + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10,4,5,8,11,6,15};
        for(int i = 1; i <= arr.length; i++){
            int ans = kthSmallest(arr, i);
            System.out.println(ans);
        }
    }
}
