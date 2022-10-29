package DP;

import java.util.Arrays;

// Minimum Subset Sum Difference
// (Partition a set into two subsets such that the difference of subset sums is minimum)
public class _1_4_min_SubsetSum_Difference {
    // Recursion  // TC : O(2^n) , SC : O(n),  which is used to store the recursion stack

    public static int minDifference(int[] arr, int totalSum, int n, int calculatedSum) { // TC : O(2^n) , SC : theta(n) for rec stack
        // If we have reached last element. Sum of one subset is calculatedSum,
        // sum of other subset is totalSum calculatedSum.
        // Return absolute difference of two sums.
        if (n == 0) {
            return Math.abs(calculatedSum - (totalSum - calculatedSum));
        }

        // For every item arr[i], we have two choices (1) We include it in first set (2) We do not include it first set
        // We return minimum of two choices
        return Math.min(minDifference(arr, totalSum, n - 1, calculatedSum + arr[n - 1]),
                minDifference(arr, totalSum, n - 1, calculatedSum));
    }

    // Returns minimum possible difference between sums of two subsets
    public static int minDifference(int[] arr, int n) {
        int sumTotal = 0;
        for (int i : arr) {
            sumTotal += i;
        }
        return minDifference(arr, sumTotal, n, 0);
    }


    // Memoization (Top down)
/*
    private static int[][] t;

    public static int minDifference(int[] arr, int totalSum, int n, int calculatedSum) {
        // base condition
        if (n == 0) {
            return Math.abs((totalSum - calculatedSum) - calculatedSum);
        }
        // check if it is valid(-1) or not , if it is valid -> return it
        if (t[n][calculatedSum] != -1) {
            return t[n][calculatedSum];
        }

        t[n][calculatedSum] = Math.min(minDifference(arr, totalSum, n - 1, calculatedSum + arr[n - 1]),
                minDifference(arr, totalSum, n - 1, calculatedSum));
        return t[n][calculatedSum];
    }

    public static int minDifference(int[] arr, int n) {
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        t = new int[n + 1][totalSum + 1];
        //-> initialize all the eles of the Matrix -1
        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));

        t[n][totalSum] = minDifference(arr, totalSum, n, 0);
        return t[n][totalSum];
    }
*/

    // Tabulation [Bottom up]
    public static int minDifferenceTab(int[] arr, int n) { // TC : O(2^n) , SC : O(n*k) , k = sum of all the elements
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        // using subset sum problem
        boolean[][] t = new boolean[n + 1][totalSum + 1];

        // Initialize 1st column as true, 0 sum is possible  with all elements.
        for (int i = 0; i <= n; i++) // If sum is 0, then answer is true
            t[i][0] = true;

        //Initialize 1st row as false, except 0(1st ele), no other sum except 0 is possible
        for (int i = 1; i <= totalSum; i++) // If n is 0 , then answer is false
            t[0][i] = false;

        // Fill the partition table in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

// above code is simple subset sum problem
        int res = Integer.MAX_VALUE;
        // find min difference
        // iterate the last row, it indicates all the valid sum of subset, ( I need to check all ele whose values are true)
        for (int i = 0; i <= totalSum; i++) {  // i <= totalSum / 2
            if (t[n][i]) {  // t[n][i] == true
                res = Math.min(res, Math.abs(i - (totalSum - i)));
            }
        }
        System.out.println(Arrays.deepToString(t));
        return res;
    }

//    Optimized Tabulation [Bottom up]  // // TC : O(2^n) , SC : O(k) , k = sum of all the elements
//    public static int minDifference(int[] arr, int n) {
//        int sumTotal = 0;
//        for(int i: arr) {
//            sumTotal += i;
//        }
//        // using subset sum problem
//        boolean[][] t = new boolean[2][sumTotal + 1];
//
//        // Initialize 1st column as true, 0 sum is possible  with all elements.
//        for(int i = 0; i < 2; i++) // If sum is 0, then answer is true
//            t[i][0] = true;
//
//        //Initialize 1st row as row, except 0(1st ele), no other sum except 0 is possible
//        for(int i = 1; i <= sumTotal; i++) // If n is 0 , then answer is false
//            t[0][i] = false;
//
//        // Fill the partition table in bottom up manner
//        for(int i = 1; i <= n; i++) {
//            for(int j = 1; j <= sumTotal; j++) {
//                if(arr[i - 1] <= j) {
//                    t[i % 2][j] = t[(i - 1) % 2][j - arr[i - 1]] || t[(i - 1) % 2][j];
//                } else {
//                    t[i % 2][j] = t[(i - 1) % 2][j];
//                }
//            }
//        }
//// above code is simple subset sum problem
//        int res = Integer.MAX_VALUE;
//        // find min difference
//        // iterate the last row, it indicates all the valid sum of subset, ( I need to check all ele whose has value true)
//        for(int i = 0; i <= sumTotal ; i++) {  // i <= sumTotal / 2
//            if(t[n % 2][i]) {  // t[n % 2][i] == true
//                res = Math.min(res, Math.abs(i - (sumTotal - i)));
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
//        int[] arr = {1,6,11,5}; // 1
        int[] arr = {1, 2, 7}; // 4
//        int[] arr = { 3, 1, 4, 2 }; // 0
        int n = arr.length;
        int res = minDifference(arr, n);
        System.out.println(res);
//        System.out.println(Arrays.toString(Arrays.stream(arr).map(a -> 2 * a).toArray()));
    }

}
