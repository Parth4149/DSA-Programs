package DP;

import java.util.Arrays;

// Longest String Chain | Longest Increasing Subsequence | LIS
public class _5_3_Longest_String_Chain {

    // s1 is a bigger str
    public static boolean checkPossible(String s1, String s2) {
        if (s1.length() != s2.length() + 1)
            return false;

        int first = 0, second = 0;
        while (first < s1.length() && second < s2.length()) {
            if (s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        if (first == s1.length() && second == s2.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static int longestStrChain(String[] arr) {

        Arrays.sort(arr, (a, b) -> a.length() - b.length());

        int n = arr.length;
        int[] dp = new int[n + 1];
        int maxi = 1;

        /* Initialize LIS values for all indexes */
        Arrays.fill(dp, 1);

        /* Compute optimized LIS values in bottom up manner */
        for (int i = 0; i < n; i++) { // 0 to n
            for (int prev = 0; prev < i; prev++) { // 0 to i-1
//                if (checkPossible(arr[i], arr[prev]) && (1 + dp[prev] > dp[i])) {
                if (checkPossible(arr[i], arr[prev]) && dp[prev] >= dp[i]) {
                    dp[i] = 1 + dp[prev];
                }
            }
//            if (dp[i] > maxi) {
//                maxi = dp[i];
//            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
    public static void main(String[] args) {
//        String[] arr = {"a","b","ba","bca","bda","bdca"}; // 4  longest word chain is "a","ba","bda","bdca".
        String[] arr = {"xbc","pcxbcf","xb","cxbc","pcxbc"}; // 5 we need to sort array according to length of str
        int ans = longestStrChain(arr);
        System.out.println(ans);
    }
}
