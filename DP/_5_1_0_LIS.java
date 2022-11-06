package DP;

import java.util.ArrayList;
import java.util.Arrays;

// Longest Increasing Subsequence
// The task is to find the longest, strictly increasing, subsequence in array
// file:///E:/DSA/9%20Grokking%20Dynamic%20Programming%20Patterns%20for%20Coding%20Interviews%20-%20Learn%20Interactively/27_Longest_Increasing_Subsequence.mhtml
public class _5_1_0_LIS {
    // Broth Force   TC : O(n^2) , this approach not give all possible subsequences
/*
    public static int lis(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int len = 1, prev_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[prev_idx]) {
                    prev_idx = j;
                    len++;
                }
            }
            res = Math.max(res, len);
        }
        return res;
    }
*/

    // Recursion ,  TC : O(2^n), SC : O(n) Auxiliary Stack space for recursion call

    public static int lis(int[] arr, int i, int prev_ind) {
        // base condition
        if (i == arr.length) {
            return 0;
        }

        // choice diagram
        // if prev_ind = -1, it doesn't have any prev element
        if (prev_ind == -1 || arr[i] > arr[prev_ind]) {
            return Math.max(1 + lis(arr, i + 1, i) , lis(arr, i + 1, prev_ind));
        } else {
            return lis(arr, i + 1, prev_ind);
        }
    }


    // Top-down Memoization
    // TC : O(n * n) , SC : O(n * n) + O(n)   , O(n) auxiliary stack space for recursion call
/*
    public static int lis(int[] arr, int i, int prev_ind,int[][] dp) {
        // base condition
        if (i == arr.length)
            return 0;

        if(dp[i][prev_ind + 1] != -1)
            return dp[i][prev_ind + 1];

        // choice diagram //  if curr ele > prev ele ,i have 2 choice either include or exclude
        // if prev_ind = -1, it doesn't have any prev element
        if (prev_ind == -1 || arr[i] > arr[prev_ind]) {
            dp[i][prev_ind + 1] = Math.max(1 + lis(arr, i + 1, i,dp) , lis(arr, i + 1, prev_ind,dp));
            return dp[i][prev_ind + 1];
        } else {
            dp[i][prev_ind + 1] = lis(arr, i + 1, prev_ind,dp);
            return dp[i][prev_ind + 1];
        }
    }
    public static int lis(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n + 1]; // OR [n+1][n+1]
        //   for(int[] a: dp)
        //       Arrays.fill(a, -1);
        Arrays.stream(dp).forEach(t -> Arrays.fill(t, -1));
        return lis(arr, 0, -1, dp);
    }
*/

/**
     // Bottom-up Tabulation
     -> base case dp[n] = 0
     -> (changing parameter) reverse     ind = n-1 to 0 , prev_ind = ind - 1 to -1
     -> copy the recurrence
        & make sure follow the coordinate shift
*/
    public static int lisTab(int[] arr) {    // TC : O(n^2) , SC : O(n^2)
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1]; // by default all the eles are 0

        for (int i = n - 1; i >= 0; i--) {
            for (int prev_ind = i; prev_ind >= -1; prev_ind--) {
                // copy the recurrence & follow coordinate shift (I add 1 in prev_ind to avoid exception)
                if (prev_ind == -1 || arr[i] > arr[prev_ind]) {
                    dp[i][prev_ind + 1] = Math.max(1 + dp[i + 1][i + 1] , dp[i + 1][prev_ind + 1]);
                } else {
                    dp[i][prev_ind + 1] = dp[i + 1][prev_ind + 1];
                }
                            // here i try to access (i + 1)'th row if i = n-1 and try to access i+1 then
            }               //i will through an Exception  so that I need to initialize [n+1][n+1]
        }
        return dp[0][-1 + 1]; // dp[0][0]
    }

    // Optimized approach TC : O(n^2) , SC : O(n)
/*
    public static int lisTabOptimized(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[2][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev_ind = i; prev_ind >= -1; prev_ind--) {
                // copy the recurrence & follow coordinate shift (I add 1 in prev_ind to avoid exception)
                if (prev_ind == -1 || arr[i] > arr[prev_ind]) {
                    dp[i % 2][prev_ind + 1] = Math.max(1 + dp[(i + 1) % 2][i + 1] , dp[(i + 1) % 2][prev_ind + 1]);
                } else {
                    dp[i % 2][prev_ind + 1] = dp[(i + 1) % 2][prev_ind + 1];
                }
            }
        }
        return dp[0][-1 + 1]; // dp[0][0]
    }
*/

    // Another Optimized approach
    public static int lisTab2(int[] arr) { // TC : O(n^2) , SC : O(n)
        int n = arr.length;
        int[] dp = new int[n];
        int maxLength = 1;

        /* Initialize LIS values for all indexes */
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) { // 1 to n
            for (int prev = 0; prev < i; prev++) { // 0 to i-1
                if (arr[i] > arr[prev] && dp[i] <= dp[prev]) {
                    dp[i] = 1 + dp[prev];
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18}; // 4  , [1, 1, 1, 2, 2, 3, 4, 4]
        int[] arr = {-4, 10, 3, 7, 15}; // 4  , [1, 2, 2, 3, 4]
        int ans = lisTab2(arr);
        printLIS(arr);
        System.out.println(ans);
    }

    public static void printLIS(int[] arr) { // TC : O(n^2) , SC : O(n)
        int n = arr.length;
        int[] dp = new int[n];
        int maxLength = 1;

        /* Initialize LIS values for all indexes */
        Arrays.fill(dp, 1);

//        ArrayList<Integer> list = new ArrayList<>();
        int[] ans = new int[n];
        for (int i = 1; i < n; i++) { // 1 to n
            for (int prev = 0; prev < i; prev++) { // 0 to i-1
                if (arr[i] > arr[prev] && dp[prev] >= dp[i]) {
                    dp[i] = 1 + dp[prev];
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        for (int i = 0; i < n; i++) { // if there are multiple equal len, consider last len in array dp
            ans[dp[i] - 1] = arr[i];
        }
        System.out.println(Arrays.toString(ans));
    }
    public static void printMatrix (int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j : arr[i]) {
                System.out.printf("%3d ",j);
            }
            System.out.println();
        }
    }
}
