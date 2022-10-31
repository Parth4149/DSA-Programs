package DP;

import java.util.Arrays;

// Longest Increasing Subsequence
//https://youtu.be/IFfYfonAFGc
public class _5_1_LIC {
    // Broth Force   TC : O(n^2) , this approach not give all possible subsequences
//    public static int lis(int[] arr) {
//        int n = arr.length;
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            int len = 1, prev_idx = i;
//            for (int j = i + 1; j < n; j++) {
//                if (arr[j] > arr[prev_idx]) {
//                    prev_idx = j;
//                    len++;
//                }
//            }
//            res = Math.max(res, len);
//        }
//        return res;
//    }

    // Recursion ,  TC : O(2^n), SC : O(n) Auxiliary Stack space
//    public static int lis(int[] arr, int i, int prev_ind) {
//        // base condition
//        if (i == arr.length) {
//            return 0;
//        }
//
//        // choice diagram
//        // if prev_ind = -1, it doesn't have any prev element
//        if (prev_ind == -1 || arr[i] > arr[prev_ind]) {
//            return Math.max(1 + lis(arr, i + 1, i) , lis(arr, i + 1, prev_ind));
//        } else {
//            return lis(arr, i + 1, prev_ind);
//        }
//    }

    // Top-down Memoization
    // TC : O(n * n) , SC : O(n * n) + O(n)   , O(n) auxiliary stack space for recursion call
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
//        for(int[] a: dp)
//            Arrays.fill(a, -1);
        Arrays.stream(dp).forEach(t -> Arrays.fill(t, -1));
        return lis(arr, 0, -1, dp);
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int ans = lis(arr);
        System.out.println(ans);
    }
}
