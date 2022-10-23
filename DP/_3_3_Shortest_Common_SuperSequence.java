package DP;

// Find the minimum length of the Subsequence
public class _3_3_Shortest_Common_SuperSequence {
/**
    public static int SCS(String X, String Y, int m, int n) {
        // base condition
        if(m == 0)
            return n;
        if(n == 0)
            return m;

        // choice diagram
        if(X.charAt(m - 1) == Y.charAt(n - 1)) { // here I omit(exclude) 2 chars and add only 1 (in length)
            return 1 + SCS(X, Y, m - 1, n - 1);
        } else {
                  // here I omit(exclude) 1 char and add only 1 (in length)
            return Math.min(1 + SCS(X, Y, m, n - 1), 1 + SCS(X, Y, m - 1, n));
        }
    }
*/
    // Another approach
//    Length of the shortest superSequence = (Sum of lengths of given two strings) - (Length of LCS of two given strings)
    public static int SCS(String X, String Y, int m, int n) {
        // Result is sum of input string lengths - length of lcs
        return (m + n) - lcs(X, Y, m, n);
    }

    public static int lcs(String X, String Y, int m, int n) {
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
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }
        return t[m][n];
    }

    public static void main(String[] args) {
        String X = "AGGT"; // AGXGT (5)
        String Y = "GXT";
//        String X = "AGGTAB";// AGXGTXAYB (9)
//        String Y = "GXTXAYB";
        int m = X.length(), n = Y.length();
//        int result = SCS(X,Y,m,n);
//        System.out.println(result);
        System.out.println(SCS(X,Y,m,n));
        System.out.println(printSCS(X,Y,m,n));
    }

    public static String printSCS(String X, String Y, int m, int n) {
        // call lcs function and it returns 2d-array(Table)
        int[][] t = LCS(X,Y,m,n);

        // The last ele of table indicate res, so I start iterating from the last ele.
        int i = m, j = n;
        StringBuilder result = new StringBuilder();
        while(i > 0 && j > 0) {
            if(X.charAt(i - 1) == Y.charAt(j - 1)) {
                result.append(X.charAt(i - 1)); // OR Y.charAt(j - 1)
                i--;
                j--;
            } else {
                if(t[i][j - 1] > t[i - 1][j]) {
                    result.append(Y.charAt(j - 1));
                    j--;
                } else {
                    result.append(X.charAt(i - 1));
                    i--;
                }
            }
        }
        // handle base cases // it may possible one of string is not complete
        while(i > 0) {
            result.append(X.charAt(i - 1));
            i--;
        }
        while(j > 0) {
            result.append(Y.charAt(j - 1));
            j--;
        }

        // here I need to reverse string becoz we start iterating from the last ele
        // so the result will come in reverse order

        result.reverse();
        return result.toString();
    }


    public static int[][] LCS(String X, String Y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        // Initialize 1st row as 0, m = 0 is possible for all eles
        for(int i = 0; i <= n; i++)
            t[0][i] = 0;

        // Initialize 1st col as 0, n = 0 is possible for all eles
        for(int i = 0; i <= m; i++)
            t[i][0] = 0;

        //[Choice diagram] Fill the t table in bottom up manner
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }
        return t;
    }

}
