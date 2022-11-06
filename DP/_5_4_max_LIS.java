package DP;
// Maximum Sum Increasing Subsequence
// file:///E:/DSA/9%20Grokking%20Dynamic%20Programming%20Patterns%20for%20Coding%20Interviews%20-%20Learn%20Interactively/28_Maximum_Sum_Increasing_Subsequence.mhtml
public class _5_4_max_LIS {

    public static int maxLIS(int[] arr, int i, int prev_ind) { // same as LIS
        // base condition
        if (i == arr.length) {
            return 0;
        }

        // choice diagram
        // if prev_ind = -1, it doesn't have any prev element
        if (prev_ind == -1 || arr[i] > arr[prev_ind]) {
            return Math.max(arr[i] + maxLIS(arr, i + 1, i) , maxLIS(arr, i + 1, prev_ind));// add arr[i] instead of 1
        } else {
            return maxLIS(arr, i + 1, prev_ind);
        }
    }

    public static void main(String[] args) {
//        int[] arr = {4,1,2,6,10,1,12}; // 32
        int[] arr = {-4,10,3,7,15}; // 25
        System.out.println(maxLIS(arr,0,-1));
    }
/*
    i/p: {4,1,2,6,10,1,12}
    o/p: 32
    Explanation: The increasing sequence is {4,6,10,12}.
    Please note the difference, as the LIS is {1,2,6,10,12} which has a sum of '31'.

    i/p: {-4,10,3,7,15}
    o/p: 25
    Explanation: The increasing sequences are {10, 15} and {3,7,15}.
*/
}
