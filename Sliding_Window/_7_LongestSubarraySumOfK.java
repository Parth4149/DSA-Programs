package Sliding_Window;
// Longest Subarray of sum K
public class _7_LongestSubarraySumOfK {
//    public static int LongestSumLength(int[] arr, int target){
//        int i = 0, j = 0, res = 0;
//        int curr_sum = 0;
//        while(j < arr.length) {
//            curr_sum += arr[j];
//            if(curr_sum < target) {
//                j++;
//            }
//            else if(curr_sum == target) {
////                System.out.println(i+" "+j);
//                res = Math.max(res, (j - i + 1)); // window size (j - i + 1)
//                j++;
//            }
//            else {
//                while(curr_sum > target && i < arr.length) {
//                    curr_sum = curr_sum - arr[i];
//                    i++;
//                }
//                //to handle 1 length of window and last window (the last element won't compute becoz j == n it come out from the loop)
//                if(curr_sum == target) {
////                    System.out.println(i+" "+j);
//                    res = Math.max(res, (j - i + 1)); // window size (j - i + 1)
//                }
//                j++;
//            }
//        }
//        return res;
//    }

    public static int LongestSumLength(int[] arr, int target) {
        int i = 0, j = 0, curr_sum = 0, res = 0;
        while(j < arr.length){
            // calculation
            curr_sum += arr[j];
            if(curr_sum < target){
                j++;
            }
            else if(curr_sum == target){
                res = Math.max(res, (j - i + 1));
                j++;
            }
            else{
                while(curr_sum > target){
                    curr_sum -= arr[i];
                    i++;
                }
                // after executing loop, there are 2 possibilities either sum < target or sum == target
                // to handle sum == target case , in next iteration we add j'th ele, so I lose this curr_sum
                if(curr_sum == target){
                    res = Math.max(res, (j - i + 1));
                }
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {4,1,1,1,2,3,5};
        int[] arr = {4,1,1,1,3,2,5};// 3 (1,1,3)
//        int[] arr = {4,5,3,4,2,6};

//        int[] arr = {4,-5,3,4,-10,2,3,6}; // this approach is not working for negative numbers
//        int[] arr = {5,-10};assume target = -5, here curr_sum = 5 which is > target then we remove 5 then add -10 which is < target
                             //  actually 5 + (-10) = -5  in this case we lose 5 therefore we cannot get ans

        System.out.println(LongestSumLength(arr,5));
    }
}
