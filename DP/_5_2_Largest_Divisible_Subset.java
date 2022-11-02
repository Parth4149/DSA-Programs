package DP;

import java.util.ArrayList;
import java.util.Arrays;

// Largest Divisible Subset  (similar to LIC)
public class _5_2_Largest_Divisible_Subset {

    public static int largestDivisibleSubset(int[] arr, int i, int prev_ind) {
        // base condition
        if (i == arr.length)
            return 0;

        // choice diagram
        // if aar[i] is divisible by arr[prev_ind] OR arr[prev_ind] is divisible by arr[i], I have 2 choices include OR exclude
        if (prev_ind == -1 || arr[i] % arr[prev_ind] == 0 || arr[prev_ind] % arr[i] == 0) {  // Only this If condition is changed
            return Math.max( 1 + largestDivisibleSubset(arr, i + 1, i) ,
                    largestDivisibleSubset(arr, i + 1, prev_ind) );
        } else {
            return largestDivisibleSubset(arr, i + 1, prev_ind);
        }
    }

/**
     // Bottom-up Tabulation
     -> base case dp[n] = 0
     -> (changing parameter) reverse     ind = n-1 to 0 , prev_ind = ind - 1 to -1
     -> copy the recurrence
     & make sure follow the coordinate shift
*/
    public static int largestDivisibleSubsetTab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            for (int prev_ind = i - 1; prev_ind >= -1; prev_ind--) { // // by default all the eles are 0
                // copy the recurrence & follow coordinate shift (I add 1 in prev_ind to avoid exception)
                if (prev_ind == -1 || arr[i] % arr[prev_ind] == 0 || arr[prev_ind] % arr[i] == 0) { //Only this If condition is changed
                    dp[i][prev_ind + 1] = Math.max(1 + dp[i + 1][i + 1] , dp[i + 1][prev_ind + 1]);
                } else {
                    dp[i][prev_ind + 1] = dp[i + 1][prev_ind + 1];
                }
            }
        }
        return dp[0][-1 + 1]; // dp[0][0]
    }

    public static void main(String[] args) {
        int[] arr = {1,16,7,8,4};
//        int ans = largestDivisibleSubset(arr, 0, -1);
        int ans = largestDivisibleSubsetTab(arr);
        System.out.println(ans);

    }
    // [ a|b & b|c => a|c ] e.g [1,4,8] , if 8 is divisible by 4, 8 must be divisible by 1
}
