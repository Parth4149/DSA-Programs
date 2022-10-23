package Sliding_Window;

// find the maximum sum of k consecutive elements (Maximum sum sub-array)
public class _1__findMaxSubOfK {
//    public static int maxSum(int[] arr, int k) {  // time : ((n-k) * k)
//        int max_sum = arr[0];
//        for(int i = 0; (i + k - 1) < arr.length; i++) {
//            int sum = 0;
//            for(int j = 0; j < k; j++) {
//                sum += arr[i + j];
//            }
//            max_sum = Math.max(max_sum, sum);
//        }
//        return max_sum;
//    }

/**
     window sliding technique:
     -> Identification : Subarray/Substring , window size, largest/smallest

     -> types:
        1. fixed size      e.g. find sum
        2. window size     e.g. find window size
*/

    public static int maxSumSubArray(int[] arr, int k){ // TC : O(k + (n-k)) = O(n)
        int curr_sum = 0;
        // compute sum for first window
        for(int i = 0; i < k; i++){
            curr_sum += arr[i];
        }
        int max_sum = curr_sum;
        // traverse the loop from k
        for(int i = k; i < arr.length; i++){
            curr_sum += (arr[i] - arr[i - k]); // add next element and subtract first element (becoz we have to maintain window size)
            max_sum = Math.max(max_sum, curr_sum);
        }
        return max_sum;
    }

    // check if consecutive sub-array present in array
    public static boolean checkSum(int[] arr, int target) { // TC : O(n)
        int curr_sum = 0;
        // compute sum for first window
        int i = 0, j = 0;
        while(j < arr.length) {
            // calculation
            curr_sum += arr[j];
            if(curr_sum < target) {
                j++;
            }
            else if(curr_sum == target) {
                return true;
            }
            else if(curr_sum > target) {
                while(curr_sum > target) {
                    curr_sum -= arr[i];
                    i++;
                }
                if(curr_sum == target) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,30,-5,20,7};
        System.out.println(maxSumSubArray(arr,3));
        System.out.println(checkSum(arr,45));
    }
}
