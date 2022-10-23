// Maximum Sum SubArray
public class _9___MaximumSubArray {
    /**
     public static int maxSum(int[] arr){   // time : O(n^2)
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            int sum = 0;
            for(int j = i; j < arr.length; j++) {
                sum += arr[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }
     */

    /** Application
     * Finding maximum subarray sum
     * Used as an image processing algorithm.
     * It can be used to solve the problems like “Station Travel in Order” and “Hotels Along the Coast”
     * It is used for business analysis.
       (maximum growth or minimum growth duration of time with which helps company to find what they did good or bad during
        those periods to repeat or prevent them in future for benefit of company.)
     */
    // Maximum Sum SubArray
    public static int maxSum(int[] arr) {  // time : O(n)   [Kadane's Algorithm]
        if(arr.length == 0) {
            return 0;
        }
        int res = arr[0];
        int maxEnding = arr[0];
        for(int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]); // here i have 2 choices, i extend subArray or start a new subArray
            res = Math.max(res, maxEnding);
        }
        return res;
    }

    /**
     * i:1	maxEnding(5, 8)  ->  res : 8
     * i:2	maxEnding(6, -2) ->	res : 8
     * i:3	maxEnding(10, 4) ->	res : 10
     * i:4	maxEnding(5, -5) ->	res : 10
     * i:5	maxEnding(11, 6) ->	res : 11
     */

    public static void main(String[] args) {
        int[] arr={-3,8,-2,4,-5,6};
        System.out.println(maxSum(arr)); // 11
    }
}

