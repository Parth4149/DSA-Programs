package DP;

// if one String is Subsequence of another String, return true. otherwise return false;
public class _3_8_Sequence_Pattern_Matching {
    public static boolean isPatternMatch(String X, String Y) {
        int m = X.length(), n = Y.length();
        // base condition
        int l = lcs(X,Y);
        return (l == Math.min(m, n));
    }
    public static int lcs(String X, String Y) {
        int m = X.length(), n = Y.length();
        int[][] t = new int[m + 1][n + 1];

        // Initialize 1st row as 0, m = 0 is possible for all eles
        for(int i = 0; i <= n; i++)
            t[0][i] = 0;

        // Initialize 1st col as 0, n = 0 is possible for all eles
        for(int i = 0; i <= m; i++)
            t[i][0] = 0;

        //[Choice diagram] Fill the t table in bottom up manner (fashion)
        for(int i = 1; i <= m; i++) {
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

    public static void main(String[] args) {
        String X = "AXY", Y = "ADXCPY";

        System.out.println(isPatternMatch(X,Y));
    }
}
