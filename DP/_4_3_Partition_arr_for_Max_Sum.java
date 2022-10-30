package DP;

import java.util.Arrays;

//  Partition Array for Maximum Sum
// https://leetcode.com/problems/partition-array-for-maximum-sum/discuss/1028098/Java-Recursive-to-Memoization-to-DP
public class _4_3_Partition_arr_for_Max_Sum {
/*
     Rule to write recurrence
    -> express everything in index
    -> try every possible partition for that index
    -> take the best partition
*/

    // Recursion  TC :
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        return maxSumAfterPartitioning(arr,k, 0);
    }
    public static int maxSumAfterPartitioning(int[] arr, int k, int i) {
        // base condition
        if (i == arr.length)
            return 0;

        // iterate from j = i to i + k
        int len = 0, currMax  = Integer.MIN_VALUE, maxAns = 0;
        for (int j = i; j < i + k && j < arr.length ; j++) { // min( i + k, n)
            len++;
            currMax  = Math.max(currMax , arr[j]);
            int leftPartitionSum = len * currMax;
            int rightPartitionSum = maxSumAfterPartitioning(arr, k, j + 1);
            maxAns = Math.max(maxAns, leftPartitionSum + rightPartitionSum);
        }
        return maxAns;
    }

/*
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return maxSumAfterPartitioning(arr, k, 0, dp);
    }

    public static int maxSumAfterPartitioning(int[] arr, int k, int i, int[] dp) {
        // base condition
        if (i == arr.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        // iterate from j = i to i + k
        int len = 0, currMax = Integer.MIN_VALUE, maxAns = 0;
        for (int j = i; j < i + k && j < arr.length; j++) { // min( i + k, n)
            len++;
            currMax = Math.max(currMax, arr[j]);
            int leftPartitionSum = len * currMax;       // len is use to calculate sum of left partition
            int rightPartitionSum = maxSumAfterPartitioning(arr, k, j + 1, dp);

            maxAns = Math.max(maxAns, leftPartitionSum + rightPartitionSum);
        }
        dp[i] = maxAns;
        return dp[i];
    }
*/
/*
    // Tabulation
    -> base case dp[n] = 0
    -> index = n-1 to 0  (changing parameter) reverse
    -> copy the recurrence
*/
    public static int maxSumAfterPartitioningTab(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        // base case
        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--) {
            // this is same as recurrence
            int len = 0, currMax = Integer.MIN_VALUE, maxAns = 0;
            for (int j = i; j < i + k && j < arr.length; j++) { // min( i + k, n)
                len++;
                currMax = Math.max(currMax, arr[j]);
                int leftPartitionSum = len * currMax;       // len is use to calculate sum of left partition
                int rightPartitionSum = dp[j + 1];

                maxAns = Math.max(maxAns, leftPartitionSum + rightPartitionSum);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
// in recursion, the index starting from 0 and ans will come at 0
// in tabulation, the index starting from n-1 because our answer will come at 0 , so we iterate from i = n-1 to 0
    public static void main(String[] args) {
//        int[] arr = {1, 15, 7, 9, 2, 5, 10}; // 84
        int[] arr = {1, 15, 7, 9, 2}; // 84
        int k = 3;
        // Explanation: arr becomes [15,15,15,9,10,10,10]
        int ans = maxSumAfterPartitioning(arr, k);
        System.out.println(ans);
    }
}
