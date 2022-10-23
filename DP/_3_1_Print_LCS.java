package DP;
import java.util.HashMap;

// Print LCS between 2 Strings
public class _3_1_Print_LCS {
    // Recursion
/*
    public static String lcs(String X, String Y, int m, int n) {
        // base condition
        if(n == 0 || m == 0) {
            return "";
        }

        // choice diagram
        if(X.charAt(m - 1) == Y.charAt(n - 1)) {
            // 1st call lcs then add char becoz we start iterating string from the last char
            return lcs(X, Y, m - 1, n - 1) + X.charAt(m - 1); // Include char
        } else {
            // I need to check for all cases (possibilities)
            String first = lcs(X, Y, m, n - 1);  // skip char Y[n-1]
            String second = lcs(X, Y, m - 1, n); // skip char X[m-1]
            return (first.length() > second.length()) ? first : second;
        }
    }
*/

    // Tabulation [Bottom-up]   // TC : O(m*n) , SC : O(m*n)
//    Using 2-D Array to store the Overlapping sub-problems.
//    Traversing the whole array to find the solution and storing in table.
    public static String printLCS(String X, String Y, int m, int n) {
        // call lcs function and it returns 2d-array(Table)
        int[][] t = lcs(X,Y,m,n);

        // The last ele of table indicate res, so I start iterating from the last ele
        int i = m, j = n;
        StringBuilder result = new StringBuilder();
        while(i > 0 && j > 0) {
            if(X.charAt(i - 1) == Y.charAt(j - 1)) {
                result.append(X.charAt(i - 1)); // OR Y.charAt(j - 1)
                i--;
                j--;
            } else {
                if(t[i][j - 1] > t[i - 1][j])  // compare res of adjacent sub-problems
                    j--;                       // j is an index of cols
                else
                    i--;
            }
        }
        // here I need to reverse string becoz we start iterating from the last ele
        // so the result will come in reverse order
        result.reverse();
        return result.toString();
    }

    public static int[][] lcs(String X, String Y, int m, int n) {
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
    public static void main(String[] args) {
        String X = "acbcf"; // abcf
        String Y = "abcdaf";
        int m = X.length(), n = Y.length();
        String result = printLCS(X,Y,m,n);
        System.out.println(result);
    }
    public static void printMatrix(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j : arr[i]) {
                System.out.printf("%3d ",j);
            }
            System.out.println();
        }
    }
}
