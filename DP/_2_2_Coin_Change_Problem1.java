package DP;

import java.util.Arrays;

// Maximum Number of ways [Count of subset sum]
public class _2_2_Coin_Change_Problem1 { // https://www.geeksforgeeks.org/coin-change-dp-7/

    // Recursion // TC: O(2^sum)
    public static int maxWays(int[] coin, int n, int sum) {
        // base condition
         // if sum is 0, there is 1 solution (do not include any coin)
        if(sum == 0)
            return 1;

         // if there is no any coins , then no solution exist
        if(n == 0 )
            return 0;

        // choice diagram
        if(coin[n - 1] <= sum) {
            return maxWays(coin, n,sum - coin[n-1]) + maxWays(coin, n - 1, sum);
        } else {
            return maxWays(coin, n - 1, sum);
        }
    }


    // Memoization [Top-down]
/**
    public static int[][] t;
    public static int maxWays(int[] coins, int n, int sum) { // TC: O(2^sum)
        // base condition
        if(sum == 0)
            return 1;

        if(n == 0)
            return 0;

        if(t[n][sum] != -1)
            return t[n][sum];

        // choice diagram
        if(coins[n - 1] <= sum) {
            t[n][sum] = maxWays(coins, n,sum - coins[n-1]) + maxWays(coins, n - 1, sum);
            return t[n][sum];
        } else {
            t[n][sum] = maxWays(coins, n - 1, sum);
            return t[n][sum];
        }
    }
*/

    // Tabulation [Bottom-up]
//    Using 2-D Array to store the Overlapping sub-problems.
//    Traversing the whole array to find the solution and storing in table.
//    find the optimal solution using table
    public static int maxWaysTab(int[] coins, int n, int sum) {
        int[][] t = new int[n + 1][sum + 1];

        // Initialize 1st col as 1, becoz sum = 0 is possible for all the ele
        for (int i = 0; i <= n; i++)
            t[i][0] = 1;

        // Initialize 1sts row as 0 except t[0][0], no other sum except 0 is possible
        // there is no any coins , then no solution exist
        for (int i = 1; i <= sum; i++)
            t[0][i] = 0;

        // choice diagram
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
//        int[] coins = {2,3,5};
        int n = coins.length, sum = 4;

//        t = new int[n + 1][sum + 1];
//        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));

        int res = maxWays(coins, n, sum);
        System.out.println(res);
    }

//    Input: sum = 4, coins[] = {1,2,3},
//    Output: 4
//    Explanation: there are four solutions: {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}.

//    Input: sum = 10, coins[] = {2, 5, 3, 6}
//    Output: 5
//    Explanation: There are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
    /**
     ({1,2,3}, 5)
     /               \
     /                   \
     ({1,2,3}, 2)                 ({1,2}, 5)
     /       \                        /     \
     /          \                      /        \
     ({1,2,3}, -1)  ({1,2}, 2)         ({1,2}, 3)     ({1}, 5)
     /     \               /     \            /    \
     /        \             /       \          /       \
     ({1,2},0)  C({1},2)   C({1,2},1) C({1},3)  ({1}, 4)  ({}, 5)
     / \           / \          /\            /    \
     /   \         /   \        /  \          /      \
     .      .  .     .   .     .        ({1}, 3)  ({}, 4)

     / \
     /   \
     */

}
