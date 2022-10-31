public class _11__maxCircularSubArraySum {

    //  Broth force approach
/*
    public static int maxCircularSubArraySum(int[] nums){       // time : O(n^2)
        if(nums.length == 0){
            return 0;
        }
        int res = nums[0];      // because elements may be negative
        int sum = 0, j , n;
        for(int i = 0; i < nums.length; i++){
            sum = 0; n = nums.length - 1;
            j = i;
            while(n >= 0){
                sum += nums[j];
                res = Math.max(res, sum);
                n--;
                if(j == nums.length - 1){
                    j = 0;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
*/
    //      Another approach   (kadane + reverseKadane )
    public static int maxCircularSubArraySum(int[] arr) {    // time : theta(n) + theta(n) = theta(n)
        return Math.max(kadane(arr), reverseKadane(arr));
    }

    public static int kadane(int[] arr) {    // time : O(n)   Kadane's Algorithm
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);//here we have 2 choices, we extend subArray or start a new subArray
            res = Math.max(res, maxEnding);
        }
        return res;
    }

    public static int reverseKadane(int[] arr) {
        int total = 0;

        //taking the total sum of the array elements
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        // inverting the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -arr[i];
        }

        // finding min sum subArray
        int k = kadane(arr); //  it returns answer which is min subArray because we are inverted the array
        //  max circular sum
        int res = total + k;

        // to handle the case in which all elements are negative
        if (total == -k) {   // here total is sum of all element of original array (not invert)
            return total;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {5,-2,3,4};//12 (10,12)
//        int[] arr = {3,-4,5,6,-8,7}; //17 (11,17)
        int[] arr = {8, -4, 3, -5, 4};//12 (8,12)   (kadane, reverseKadane)
//        int[] arr = {-8,-4, 2, 5,-4}; //7 (7,3)
//      if maxSum is in circular array, then we use reverseKadane otherwise we use kadane therefore we return max(kadane,reverseKadane)
        System.out.println(maxCircularSubArraySum(arr));
    }
}
