package DP;

import java.util.Arrays;

// Count of subset sum with a given sum
public class _1_3_Count_Subset_Sum {
    // Recursive
/*
    public static int countSubsetSum(int[] set, int n, int sum) {
        // base condition
        if (sum == 0)
            return 1;

        if (n == 0)
            return 0;

        // choice diagram
        if (set[n - 1] <= sum) {
            return countSubsetSum(set, n - 1, sum - set[n - 1]) + countSubsetSum(set, n - 1, sum);
        } else {
            return countSubsetSum(set, n - 1, sum);
        }
    }
*/
    // Memoization [Top down]
/**
    private static int[][] t;
    public static int countSubsetSum(int[] arr, int n, int sum) {
        // base condition
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
        if (t[n][sum] != -1) // do not calculate again, simply return the ans of calculated sub-problems
            return t[n][sum];

        // choice diagram
        if (arr[n - 1] <= sum) {
            t[n][sum] = countSubsetSum(arr, n - 1, sum - arr[n - 1]) + countSubsetSum(arr, n - 1, sum);
            return t[n][sum];
        } else {
            t[n][sum] = countSubsetSum(arr, n - 1, sum);
            return t[n][sum];
        }
    }
*/

    // Tabulation [Bottom-up]
//    Using 2-D Array to store the Overlapping sub-problems.
//    Traversing the whole array to find the solution and storing in table.
    public static int countSubsetSum(int[] arr, int n, int sum) {
        // initialize table t (2d array)
        int[][] t = new int[n + 1][sum + 1];

        // base condition
        // Initialize 1st col as 1 bcz sum = 0 is possible for all the ele
        for (int i = 0; i <= n; i++)
            t[i][0] = 1;

        // Initialize 1sts row as 0 except t[0][0], no other sum except 0 is possible
        for (int i = 1; i <= sum; i++)
            t[0][i] = 0;

        //[Choice diagram] Fill the t table in bottom up manner
        for (int i = 1; i <= n; i++) {  // n -> i ,  sum -> j
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int n = arr.length, sum = 10;
//        t = new int[n + 1][sum + 1];
//        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));

        int result = countSubsetSum(arr, n, sum);
        System.out.println(result);
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j : arr[i]) {
                System.out.printf("%3d ", j);
            }
            System.out.println();
        }
    }
}
