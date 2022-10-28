package DP;

import java.util.Collections;
public class _3_5_Longest_Palindromic_Subsequence {

    public static int LPS(String X) {
        String Y = reverse(X);
        int m = X.length(), n = Y.length();
        return lcs(X, reverse(X), m, n);
    }

    // Tabulation [Bottom-up]       TC : O(m*n)   Sc : O(m*n)
    public static int lcs (String X, String Y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        // Initialize 1st row as 0, m = 0 is possible for all eles
        for (int i = 0; i <= n; i++)
            t[0][i] = 0;

        // Initialize 1st col as 0, n = 0 is possible for all eles
        for (int i = 0; i <= m; i++)
            t[i][0] = 0;

        //[Choice diagram] Fill the t table in bottom up manner (fashion)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]); // consider max of 2 sub-problems
                }
            }
        }
        return t[m][n];
    }

    public static String reverse(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            str = swap(str, i, j);
            i++;
            j--;
        }
        return str;
    }
    public static String swap(String str, int a, int b) {
        char[] charArray = str.toCharArray();
        char temp = charArray[a];
        charArray[a] = charArray[b];
        charArray[b] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String X = "agbcba";
        int result = LPS(X);
        System.out.println(result);
    }
}
