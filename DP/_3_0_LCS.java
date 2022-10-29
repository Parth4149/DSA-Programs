package DP;
import java.util.HashMap;

// Longest Common Subsequence
// Find the length of the longest common subsequence
public class _3_0_LCS {

    // Recursion        TC : 2^(m+n)
    public static int lcs(String X, String Y, int m, int n) {
        // base condition
        if (m == 0 || n == 0) {
            return 0;
        }

        // choice diagram
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return 1 + lcs(X, Y, m - 1, n - 1);
        } else {
                // here omit(exclude) 1 char I don't know what char, so 1st i exclude char of X and Y, return the max of them
            return Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n)); // return max res of 2 sub-problems
        }
    }


    // Memoization [Top-down]       TC : O(m*n)   Sc : O(m*n)
/*
    public static int lcs(String X, String Y, int m, int n, int[][] t) {
        // base condition
        if (m == 0 || n == 0) {
            return 0;
        }
        if (t[m][n] != -1) {
            return t[m][n];
        }

        // choice diagram
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            t[m][n] = 1 + lcs(X, Y, m - 1, n - 1, t);
            return t[m][n];
        } else {
            t[m][n] = Math.max(lcs(X, Y, m, n - 1, t) , lcs(X, Y, m - 1, n, t));
            return t[m][n];
        }
    }
*/

    // Tabulation [Bottom-up]       TC : O(m*n)   Sc : O(m*n)
/**
     -> Initialize base case
     -> choice diagram [changing parameter (reverse iteration)]
     -> copy the recurrence
*/
//    Using 2-D Array to store the Overlapping sub-problems.
//    Traversing the whole array to find the solution and storing in table.

    public static int lcsTab(String X, String Y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        // Initialize 1st row as 0, m = 0 is possible for all eles
        for (int i = 0; i <= n; i++)
            t[0][i] = 0;

        // Initialize 1st col as 0, n = 0 is possible for all eles
        for (int i = 0; i <= m; i++)
            t[i][0] = 0;

        //[Choice diagram] Fill the t table in bottom up manner (fashion)
        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]); // consider max of 2 sub-problems
                }
            }
        }
        return t[m][n];
    }

    // [Space optimized approach]  Optimized Tabulation (Bottom-up)       TC : O(m*n)   SC : O(n)
/**
    public static int lcsOptimized(String X, String Y, int m, int n) {
        int[][] t = new int[2][n + 1];

        // Initialize 1st row as 0, m = 0 is possible for all eles
        for(int i = 0; i <= n; i++)
            t[0][i] = 0;

        // Initialize 1st col as 0, n = 0 is possible for all eles
        for(int i = 0; i < 2; i++)
            t[i][0] = 0;
        //[Choice diagram] Fill the t table in bottom up manner
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i % 2][j] = 1 + t[(i-1) % 2][j - 1];
                } else {
                    t[i % 2][j] = Math.max(t[i % 2][j - 1], t[(i-1) % 2][j]);
                }
            }
        }
        return t[m % 2][n];
    }
*/

    public static void main(String[] args) {
        String X = "ABCDGH";
        String Y = "AEDFHR";
        int m = X.length(), n = Y.length();

        //-> Memoization (Top down)
//        int[][] t = new int[m + 1][n + 1];
//        // initialize all the eles of the Matrix -1
//        Arrays.stream(t).forEach(a -> Arrays.fill(a,-1));
//        int result = lcs(X,Y,m,n, t);

        //-> Tabulation (Bottom up)
//        int result = lcs(X,Y,m,n);
        int result = lcs(X,Y,m,n);
        System.out.println(result);
    }
    // LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
    // LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GRAB” of length 4.

    public static void printMatrix(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j : arr[i]) {
                System.out.printf("%3d ",j);
            }
            System.out.println();
        }
    }
}
