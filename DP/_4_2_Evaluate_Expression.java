package DP;

// Evaluate Boolean Expression to True

import java.util.Arrays;

// Returns count of all possible parenthesizations that lead to result true for a boolean expression with symbols like true
// and false and operators like &, | and ^ filled between symbols
public class _4_2_Evaluate_Expression {
/*
    // Recursion
    TC : O(n3), as we are using a loop to traverse, n times, and we are making recursive calls which will cost n2 times.
        Where n is the length of the symbols string.
*/
/*
    public static int evaluateExpression(String exp) {
        int i = 0, j = exp.length() - 1;
        return countParenthesis(exp, i, j, 1);
    }

    public static int countParenthesis(String str, int i, int j, int isTrue) {
        // base condition
        if (i > j) // empty str
            return 0;

        if (i == j) { // if there is only 1 char in string
            if (isTrue == 1)
                return (str.charAt(i) == 'T') ? 1 : 0;
            else
                return (str.charAt(i) == 'F') ? 1 : 0;
        }

        // iterate k = i+1 to j-1
        int temp_ans = 0;
        int leftTrue, leftFalse, rightTrue, rightFalse;

        // iterate k = i+1 to j-1 ,do not include operator(k) in a group
        for (int k = i + 1; k <= j - 1; k = k + 2) { // how many ways this exp can true and false

            leftTrue = countParenthesis(str, i, k - 1, 1); // Count number of True in left Partition
            leftFalse = countParenthesis(str, i, k - 1, 0); // Count number of False in left Partition
            rightTrue = countParenthesis(str, k + 1, j, 1); // Count number of True in right Partition
            rightFalse = countParenthesis(str, k + 1, j, 0); // Count number of False in right Partition

            // Evaluate AND operation
            if (str.charAt(k) == '&') { // AND table T & T = T,  T & F = F,  F & T = F,  F & F = F
                if (isTrue == 1) { // true
                    temp_ans = temp_ans + leftTrue * rightTrue;
                } else {              // false
                    temp_ans = temp_ans
                            + leftTrue * rightFalse
                            + leftFalse * rightTrue
                            + leftFalse * rightFalse;
                }
            }

            // Evaluate OR operation
            else if (str.charAt(k) == '|') { // OR table T & T = T,  T & F = T,  F & T = T,  F & F = F
                if (isTrue == 1) {
                    temp_ans = temp_ans
                            + leftTrue * rightTrue
                            + leftTrue * rightFalse
                            + leftFalse * rightTrue;
                } else {
                    temp_ans = temp_ans + leftFalse * rightFalse;
                }
            }

            // Evaluate XOR operation
            else if (str.charAt(k) == '^') { // XOR table T & T = F,  T & F = T,  F & T = T,  F & F = F
                if (isTrue == 1) {
                    temp_ans = temp_ans
                            + leftTrue * rightFalse
                            + leftFalse * rightTrue;
                } else {
                    temp_ans = temp_ans
                            + leftTrue * rightTrue
                            + leftFalse * rightFalse;
                }
            }
        }
        return temp_ans;
    }
*/
    /*
         Top-down Memoization
         TC : O(n^3), as we are using a loop to traverse, n times, and we are making recursive calls which will cost n2 times.
               Where n is the length of the symbols string.
         SC: O(n^2), as we are using extra space for the DP matrix. Where n is the length of the symbols string.
    */
    public static int evaluateExpression(String str) {
        int n = str.length();
        int i = 0, j = n - 1;
        int[][][] dp = new int[n + 1][n + 1][2];
        // initialize all ele -1
        // Arrays.stream(dp).forEach( t -> Arrays.stream(t).forEach(i -> Arrays.fill(i, -1)));
        for (int[][] row : dp)
            for (int[] col : row)
                Arrays.fill(col, -1);

        return parenthesis_count(str, 0, n - 1, 1, dp);
    }

    public static int parenthesis_count(String str, int i, int j, int isTrue, int[][][] dp) {
        // base condition
        if (i > j) // empty str
            return 0;

        if (i == j) { // if there is only 1 char in string
            if (isTrue == 1)
                return (str.charAt(i) == 'T') ? 1 : 0;
            else
                return (str.charAt(i) == 'F') ? 1 : 0;

        }

        if (dp[i][j][isTrue] != -1) { //
            return dp[i][j][isTrue];
        }

        int temp_ans = 0;
        int leftTrue, rightTrue, leftFalse, rightFalse;

        for (int k = i + 1; k <= j - 1; k = k + 2) {

            leftTrue = parenthesis_count(str, i, k - 1, 1, dp); // Count number of True in left Partition
            leftFalse = parenthesis_count(str, i, k - 1, 0, dp); // Count number of False in left Partition
            rightTrue = parenthesis_count(str, k + 1, j, 1, dp); // Count number of True in right Partition
            rightFalse = parenthesis_count(str, k + 1, j, 0, dp); // Count number of False in right Partition

            // Evaluate AND operation
            if (str.charAt(k) == '&') { // AND table T & T = T,  T & F = F,  F & T = F,  F & F = F
                if (isTrue == 1) { // true
                    temp_ans = temp_ans + leftTrue * rightTrue;
                } else {              // false
                    temp_ans = temp_ans
                            + leftTrue * rightFalse
                            + leftFalse * rightTrue
                            + leftFalse * rightFalse;
                }
            }
            // Evaluate OR operation
            else if (str.charAt(k) == '|') { // OR table T & T = T,  T & F = T,  F & T = T,  F & F = F
                if (isTrue == 1) {
                    temp_ans = temp_ans
                            + leftTrue * rightTrue
                            + leftTrue * rightFalse
                            + leftFalse * rightTrue;
                } else {
                    temp_ans = temp_ans + leftFalse * rightFalse;
                }
            }

            // Evaluate XOR operation
            else if (str.charAt(k) == '^') { // XOR table T & T = F,  T & F = T,  F & T = T,  F & F = F
                if (isTrue == 1) {
                    temp_ans = temp_ans
                            + leftTrue * rightFalse
                            + leftFalse * rightTrue;
                } else {
                    temp_ans = temp_ans
                            + leftTrue * rightTrue
                            + leftFalse * rightFalse;
                }
            }
            System.out.println(temp_ans);
            dp[i][j][isTrue] = temp_ans;
        }
        return temp_ans;
    }

    // Optimized
/*
    public static int parenthesis_count(String str, int i, int j, int isTrue, int[][][] dp){
        if (i > j)
            return 0;

        if (i == j) {
            if (isTrue == 1)
                return (str.charAt(i) == 'T') ? 1 : 0;
            else
                return (str.charAt(i) == 'F') ? 1 : 0;

        }

        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }

        int temp_ans = 0;
        int leftTrue, rightTrue, leftFalse, rightFalse;

        for (int k = i + 1; k <= j - 1; k = k + 2) {

            if (dp[i][k - 1][1] != -1) {
                leftTrue = dp[i][k - 1][1];
            }
            else { // Count number of True in left Partition
                leftTrue = parenthesis_count(str, i, k - 1,1, dp);
            }

            if (dp[i][k - 1][0] != -1) {
                leftFalse = dp[i][k - 1][0];
            }
            else { // Count number of False in left Partition
                leftFalse = parenthesis_count(str, i, k - 1, 0, dp);
            }

            if (dp[k + 1][j][1] != -1) {
                rightTrue = dp[k + 1][j][1];
            }
            else { // Count number of True in right Partition
                rightTrue = parenthesis_count(str, k + 1, j,1, dp);
            }

            if (dp[k + 1][j][0] != -1) {
                rightFalse = dp[k + 1][j][0];
            }
            else { // Count number of False in right Partition
                rightFalse = parenthesis_count(str, k + 1, j, 0, dp);
            }

            // Evaluate AND operation
            if (str.charAt(k) == '&') { // table T & T = T,  T & F = F,  F & T = F,  F & F = F
                if (isTrue == 1) { // true
                    temp_ans = temp_ans + leftTrue * rightTrue;
                }
                else {              // false
                    temp_ans = temp_ans
                            + leftTrue * rightFalse
                            + leftFalse * rightTrue
                            + leftFalse * rightFalse;
                }
            }
            // Evaluate OR operation
            else if (str.charAt(k) == '|') {
                if (isTrue == 1) {
                    temp_ans = temp_ans
                            + leftTrue * rightTrue
                            + leftTrue * rightFalse
                            + leftFalse * rightTrue;
                }
                else {
                    temp_ans = temp_ans + leftFalse * rightFalse;
                }
            }

            // Evaluate XOR operation
            else if (str.charAt(k) == '^') {
                if (isTrue == 1) {
                    temp_ans = temp_ans
                            + leftTrue * rightFalse
                            + leftFalse * rightTrue;
                }
                else {
                    temp_ans = temp_ans
                            + leftTrue * rightTrue
                            + leftFalse * rightFalse;
                }
            }
            dp[i][j][isTrue] = temp_ans;
        }
        return temp_ans;
    }
*/

    public static void main(String[] args) {
        String s = "T|T&F^T"; // expression
        // There are 4 ways
        // ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T))
        int ans = evaluateExpression(s);
        System.out.println(ans);
    }
}
