package DP;

import java.util.Arrays;

/**
 * Applications:
 * One application you can relate to easily is that of perspective projections, which is the foundation for 3D animation.
   This is the link : 3D projection <a href="https://en.wikipedia.org/wiki/3D_projection">...</a>
 * Basically, what is seen on the computer screen is a 2D picture representing a point in 3D space.
   Matrix multiplication allows you to convert between 2D and 3D worlds.
 * <a href="https://qr.ae/pvxRsT">...</a>
 * <a href="https://qr.ae/pvemDO">...</a>
 */
/*
 * If A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix, then
        computing (AB)C needs (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations, while
        computing A(BC) needs (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.

        Clearly the first method is more efficient
 */

//    Create a recursive function that takes i and j as parameters that determines the range of a group.
//  * Iterate from k = i to j to partition the given range into two groups.
//  * Call the recursive function for these groups.
//  * Return the minimum value among all the partitions

// Matrix Ai has dimension arr[i-1] x arr[i]
// for i = 1 . . . n

// Minimum number of multiplication
// https://www.scaler.com/topics/matrix-chain-multiplication
public class _4_0_MatrixChainMultiplication {
    /**
     Rule to write recurrence
     -> express everything in terms of index
     -> try every possible partition for that index
     -> take the best partition
     -> base case
     */

    // Naive Recursion
    // TC : O(2^n)
    // SC : O(N) // The maximum depth of the recursive tree can reach up to O(n), where n is the length of the matrix chain.
    private static int MatrixChainMultiplication(int[] arr, int i, int j) { // if array is an empty then i = 1, j = len - 1 = 0 - 1
        // there is one matrix in a group, we don't need any multiplication steps.
        if (i >= j)
            return 0;

        // Initializing minCost with very large value.
        int minCost = Integer.MAX_VALUE;

        // Iterating from i to j - 1
        for (int k = i; k <= j - 1; k++) { // recursively calculate count of multiplications
            /*
             Cost = Cost of Multiplying chain on left side +
                    Cost of Multiplying chain on right side +
                    Cost of Multiplying matrix obtained from left and right side.
            */
            int cost = MatrixChainMultiplication(arr, i, k) +
                    MatrixChainMultiplication(arr, k + 1, j) +
                    arr[i-1] * arr[k] * arr[j];

            // If the above cost is less than minCost find so far then update minCost.
            minCost = Math.min(minCost, cost);
        }
        // Returning the minCost
        return minCost;
    }

    // Top-down Memoization  // TC : O(n^3) , SC : O(n^2)
    private static int[][] t;
    public static int matrixChainMultiplication(int[] arr, int i, int j) {
        // there is one matrix in a group, we don't need any multiplication steps.
        if (i >= j)
            return 0;

        // we already have solved this sub-problem. So we will instantly return it.
        if (t[i][j] != -1)
            return t[i][j];

        // Initializing minCost with MAX_VALUE;
        int minCost = Integer.MAX_VALUE;

        // iterate from i to j - 1
        for (int k = i; k <= j - 1; k++) {
            /*
             Cost = Cost of Multiplying chain on left side +
                    Cost of Multiplying chain on right side +
                    Cost of Multiplying matrix obtained from left and right side.
            */
            int cost = matrixChainMultiplication(arr, i, k) +
                    matrixChainMultiplication(arr,k + 1, j) +
                    arr[i - 1] * arr[k] * arr[j];

            // If the above cost is less than minCost find so far then update minCost.
            minCost = Math.min(minCost, cost);
        }
        t[i][j] = minCost;
        return t[i][j];
    }

    // Bottom up Tabulation
/**
     -> Initialize base case
     -> choice diagram [changing parameter (reverse iteration)]
     -> copy the recurrence
*/
    // TC : O(n^3) We are using three nested for loops, each of which is iterating roughly O(n)O(n) times
    // SC : O(n^2)
    public static int matrixChainMultiplicationTab(int[] arr) {
        //
        int n = arr.length;
        int[][] dp = new int[n][n];
        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < n; j++) {

                // base condition
                if (i >= j) {
                    t[i][j] = 0;
                    continue;
                }

                // this is recurrence copy from recursion
                int minCost = Integer.MAX_VALUE;

                // iterate from i to j - 1
                for (int k = i; k <= j - 1; k++) {
                    int cost = t[i][k] + t[k + 1][j] + arr[i - 1] * arr[k] * arr[j];

                    minCost = Math.min(minCost, cost);
                }
                t[i][j] = minCost;

            }
        }
        System.out.println(Arrays.deepToString(t));
        return t[1][n - 1]; //
    }
// in recursion, we pass i = 1 and j = n-1 as an argument -> ans will come i = 1 and j = n-1
// in tabulation, the index i starts from n-1 & j = 0 because our answer will come at i = 1 & j = n-1 (reverse iteration)

    public static void main(String[] args){
        // This matrix chain of length 5 represents 4 matrices of dimensions as follows 2*4, 4*6, 6*8, and 8*6.
        int[] arr = {2, 4, 6, 8, 6}; // 240
//        int[] arr = {1, 2, 3, 4, 3};
        int n = arr.length;
//        int result = MatrixChainMultiplication(arr, 1, n  - 1);

//        t = new int[n][n];
//        //  initialize all the cells(elements) -1
//        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));
//        int result = matrixChainMultiplication(arr, 1, n - 1);
        int result = matrixChainMultiplicationTab(arr);


        System.out.println("Minimum number of steps are : " + result);
    }
}
