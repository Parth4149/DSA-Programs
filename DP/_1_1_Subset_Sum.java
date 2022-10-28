package DP;

import java.util.Arrays;

// Subset Sum Problem
public class _1_1_Subset_Sum {
    // Recursive  TC : O(2^n)   SC : O(n) for recursion(call) stack
    // Complexity Analysis: The solution may try all subsets of given set in worst case.
    // Therefore, time complexity of the above solution is exponential.
/**
    public static boolean isSubsetSum(int[] arr, int n, int sum) {
        // base condition
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        // choice diagram        // here we cannot compare bool vals, so we use OR operator instead of max
        // if I include the ele, our capacity(sum) will be reduced, so i need to subtract sum(target) by ele.
        if (arr[n - 1] <= sum) {
            // 2 choices I include value of item or exclude(omit) , if I include, i need to subtract it in sum
            return isSubsetSum(arr, n - 1, sum - arr[n - 1]) || isSubsetSum(arr, n - 1, sum);
        } else {
            return isSubsetSum(arr, n - 1, sum);
        }
    }
*/

// if i check for a sum k, i can derive every possible sum between 0 and k

    // Memoization [Top down]
    // we have to make Matrix of changeable values (of Input)
/**
    static boolean[][] t;
    public static boolean isSubsetSum(int[] arr, int n, int sum) {
        // base condition
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        // choice diagram
        if (arr[n - 1] <= sum) {
            t[n][sum] = isSubsetSum(arr, n - 1, sum - arr[n - 1]) || isSubsetSum(arr, n - 1, sum);
            return t[n][sum];
        } else {
            t[n][sum] = isSubsetSum(arr, n - 1, sum);
            return t[n][sum];
        }
    }
*/

    // Tabulation [Bottom-up]
    // Using 2-D Array to store the Overlapping sub-problems.
    // Traversing the whole array to find the solution and storing in table.

    // Returns true if there is a subset of arr[] with sum equal to given sum
    public static boolean isSubsetSum(int[] arr, int n, int sum) { // tC : O(sum*n) , SC : O(sum*n)
        // The value of t[i][j] will be true if there is a subset of arr[0..j-1] with sum equal to i
        boolean[][] t = new boolean[n + 1][sum + 1];

        // base condition
        // Initialize 1st column as true, 0 sum is possible  with all elements.
        for (int i = 0; i <= n; i++) // If sum is 0, then answer is true
            t[i][0] = true;

        //Initialize 1st row as false, except 0(1st ele), no other sum except 0 is possible
        for (int i = 1; i <= sum; i++) // If n is 0 , then answer is false
            t[0][i] = false;

        //[Choice diagram] Fill the t table in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }
    // [Space optimized approach] Optimized Tabulation (Bottom up) similar to above approach
//    public static boolean isSubsetSumOptimized(int[] set, int n, int sum) { // tC : O(n*sum) , SC : O(2*sum)
//        // The value of t[i][j] will be true if there is a subset of set[0..j-1] with sum equal to i
//        boolean[][] t = new boolean[2][sum + 1];
//
//        // base condition
//        // If sum is 0, then answer is true
//        for (int i = 0; i < 2; i++) {
//            t[i][0] = true;
//        }
//
//        // If sum is not 0 and set is empty, then answer is false
//        for (int i = 1; i <= sum; i++) {
//            t[0][i] = false;
//        }
//        //[Choice diagram] Fill the t table in bottom up manner
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= sum; j++) {
//                if (set[i - 1] <= j) {
//                    t[i % 2][j] = t[(i - 1) % 2][j - set[i - 1]] || t[(i - 1) % 2][j];
//                } else {
//                    t[i % 2][j] = t[(i - 1) % 2][j];
//                }
//            }
//            System.out.println(Arrays.deepToString(t));
//        }
//        return t[n % 2][sum];
//    }

    public static void main(String[] args) {
        int[] set = {2, 4, 1, 2};
//        int[] set = {3, 34, 4, 12, 5, 2};
        int n = set.length, sum = 5;
//        t = new boolean[n + 1][sum + 1];

        System.out.println(isSubsetSum(set, n, sum));
//        System.out.println(isSubsetSumOptimized(set, n, sum));
    }

    // Optimized Tabulation [Bottom up]

//            [[true, false, false, false, false, false], 1st
//             [true, false, true, false, false, false]]  2nd  // we solve 2nd row using result of 1st row@

//            [[true, false, true, false, true, false],   3rd  // similarly 3rd row, here I won't need the res of 1st row,
//             [true, false, true, false, false, false]]  2nd  // so I reuse the 1st for storing res of 3rd row

//            [[true, false, true, false, true, false],   3rd
//             [true, true, true, true, true, true]]      4th

//            [[true, true, true, true, true, true],    5th
//             [true, true, true, true, true, true]]    4th
}
