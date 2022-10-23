package DP;

import java.util.Arrays;

// find the length of The Longest Common Substring
public class _3_2_Longest_Common_Substring {

    // Tabulation [Bottom-up]
//    Using 2-D Array to store the Overlapping sub-problems.
//    Traversing the whole array to find the solution and storing in table.
    public static int longestCommonSubstring(String X, String Y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        // Initialize 1st row as 0, m = 0 is possible for all eles
        for(int i = 0; i <= n; i++)
            t[0][i] = 0;

        // Initialize 1st col as 0, n = 0 is possible for all eles
        for(int i = 0; i <= m; i++)
            t[i][0] = 0;

        int result = 0;
        //[Choice diagram] Fill the t table in bottom up manner (fashion)
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    result = Math.max(result, t[i][j]);
                } else {
                    t[i][j] = 0; // we do not consider max of 2 sub-problems
                }
            }
        }
        return result;
    }

    // [Space optimized approach]. Optimized Tabulation [Bottom-up] TC : O(m*n) , SC : O(n)
    public static int longestCommonSubstring2(String X, String Y, int m, int n) {
        int[][] t = new int[2][n + 1];

        // Initialize 1st row as 0, m = 0 is possible for all eles
        for(int i = 0; i <= n; i++)
            t[0][i] = 0;

        // Initialize 1st col as 0, n = 0 is possible for all eles
        for(int i = 0; i <= 1; i++)
            t[i][0] = 0;

        int result = 0;
        //[Choice diagram] Fill the t table in bottom up manner (fashion)
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i % 2][j] = 1 + t[(i - 1) % 2][j - 1];
                    result = Math.max(result, t[i % 2][j]);
                } else {
                    t[i % 2][j] = 0; // only change this
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String X = "abcdexp";
        String Y = "abfcdeyq"; // cde
        int m = X.length(), n = Y.length();
        int result = longestCommonSubstring(X,Y,m,n);
        System.out.println(result);
    }
}
