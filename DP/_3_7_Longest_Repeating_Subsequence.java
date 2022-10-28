package DP;

public class _3_7_Longest_Repeating_Subsequence {   // Similar to LCS
    public static int longestRepeatingSubsequence(String str) { // TC : O(m*n)   Sc : O(m*n)
        String X = str, Y = str;
        int m = X.length(), n = Y.length();
        int[][] t = new int[m + 1][n + 1];
        // Initialize 1st row as 0, m = 0 is possible for all eles
        for (int i = 0; i <= m; i++)
            t[0][i] = 0;

        // Initialize 1st col as 0, n = 0 is possible for all eles
        for (int i = 0; i <= n; i++)
            t[i][0] = 0;

        //[Choice diagram] Fill the t table in bottom up manner (fashion)
        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(X.charAt(i - 1) == Y.charAt(j - 1) && i != j) { // add only (i != j)
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1] , t[i - 1][j]);
                }
            }
        }
        return t[m][n];
    }

    // Optimized    // TC : O(m*n)   Sc : O(n)
    public static int longestRepeatingSubsequence2(String str) {
        String X = str, Y = str;
        int m = X.length(), n = Y.length();
        int[][] t = new int[2][n + 1];
        // Initialize 1st row as 0, m = 0 is possible for all eles
        for (int i = 0; i <= m; i++)
            t[0][i] = 0;

        // Initialize 1st col as 0, n = 0 is possible for all eles
        for (int i = 0; i <= 1; i++)
            t[i][0] = 0;

        //[Choice diagram] Fill the t table in bottom up manner (fashion)
        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(X.charAt(i - 1) == Y.charAt(j - 1) && i != j) { // add only (i != j)
                    t[i % 2][j] = 1 + t[(i - 1) % 2][j - 1];
                } else {
                    t[i % 2][j] = Math.max(t[i % 2][j - 1] , t[(i - 1) % 2][j]);
                }
            }
        }
        return t[m % 2][n];
    }

    public static void main(String[] args) {
        String s = "AABEBCDD";
        int result = longestRepeatingSubsequence2(s);
        System.out.println(result);
    }
}
