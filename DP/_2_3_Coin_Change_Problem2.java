package DP;

// Minimum Number of Coins [Unique Problem]
public class _2_3_Coin_Change_Problem2 {

    // Recursion
/**
    public static int minCoins(int[] coins, int n, int sum) {
        // base condition
        if(n == 0) {   // this will cover 1 corner case (0,0) , so that I write this 1st
            return Integer.MAX_VALUE - 1;  // there is no any chance to count min no. of coins
        if(sum == 0)
            return 0;

        if(n == 1) {                                // 2nd row ( we can avoid multiple function calls by using this)
            if(sum % coins[0] == 0)                 // check if it is possible add coins in order to sum becomes 0
                return sum / coins[0];
            else
                return Integer.MAX_VALUE - 1;
        }

        // choice diagram
        if(coins[n - 1] <= sum) {
            return Math.min(1 + minCoins(coins, n, sum - coins[n-1]), minCoins(coins, n - 1, sum));
        } else {
            return minCoins(coins, n - 1, sum);
        }
    }
*/
    // Tabulation [Bottom up]
//    Using 2-D Array to store the Overlapping sub-problems.
//    Traversing the whole array to find the solution and storing in table.
    public static int minCoins(int[] coins, int n, int sum) {
        int[][] t = new int[n + 1][sum + 1];
        // initialize 1st row It may possible the value of coin is 0, then res will be infinite
        for(int i = 0; i <= sum; i++)
            t[0][i] = Integer.MAX_VALUE - 1;

        // Initialize 1st column as 0, 0 sum is possible with all elements.
        for(int i = 1; i <= n; i++)
            t[i][0] = 0;

        // 2nd row, I need to initialize 2nd row According to the value of 1st coin
        for(int i = 1; i <= sum; i++) {  // check if sum is divisible by 1st ele or not
            if(i % coins[0] == 0) // 1st coin
                t[1][i] = i / coins[0];
            else
                t[1][i] = Integer.MAX_VALUE - 1;
        }

        // choice diagram
        // Fill the partition table in bottom up manner
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(coins[i - 1] <= j) {
                    t[i][j] = Math.min(1 + t[i][j - coins[i-1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }
// Optimized Tabulation
/**
    public static int minCoinsOptimized(int[] coins, int n, int sum) {
        int[][] t = new int[2][sum + 1];
        // initialize 1st row It is possible the value of sum  and coin is 0, then res will be infinite
        for(int i = 0; i <= sum; i++)
            t[0][i] = Integer.MAX_VALUE - 1;

        // Initialize 1st column as 0, 0 sum is possible with all elements.
        for(int i = 1; i <= 1; i++)
            t[i][0] = 0;

        // 2nd row, I need to initialize 2nd row According to the value of 1st coin
        for(int i = 1; i <= sum; i++) {  // check if sum is divisible by 1st ele or not
            if(i % coins[0] == 0) // 1st coin
                t[1][i] = i / coins[0];
            else
                t[1][i] = Integer.MAX_VALUE - 1;
        }

        // choice diagram
        // Fill the partition table in bottom up manner
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(coins[i - 1] <= j) {
                    t[i % 2][j] = Math.min(1 + t[i % 2][j - coins[i-1]], t[(i - 1)%2][j]);
                } else {
                    t[i % 2][j] = t[(i - 1) % 2][j];
                }
            }
        }
        return t[n % 2][sum];
    }
*/

    public static void main(String[] args) {
//        int[] coins = {1,2,3};
        int[] coins = {1,2,5};
        int n = coins.length, sum = 11; // 3
        int res = minCoins(coins, n, sum);  //
//        int res = maxCoins(coins, n, sum);
        System.out.println(res);
    }

    // Maximum Number of Coin
    public static int maxCoins(int[] coins, int n, int sum) {
        // base condition
        if(n == 0) // this will cover 1 corner case (0,0) , so that I write this 1st
            return Integer.MIN_VALUE;
        if(sum == 0)
            return 0;

        // choice diagram
        if(coins[n - 1] <= sum) {
            return Math.max(1 + maxCoins(coins,n,sum - coins[n-1]), maxCoins(coins,n - 1, sum));
        } else {
            return maxCoins(coins,n - 1, sum);
        }
    }
}
