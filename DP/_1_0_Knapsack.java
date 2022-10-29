package DP;

import java.util.Arrays;

// 0/1 Knapsack   // https://algorithm-visualizer.org/dynamic-programming/knapsack-problem
public class _1_0_Knapsack {

    // 1st Recursion
    // TC : O(2^n). As there are redundant sub-problems.
    // SC :O(1) + O(N). As no extra data structure has been used for storing values but O(N) auxiliary stack space(ASS) has been
    // used for recursion stack.

    public static int knapsack(int[] weight, int[] value, int n, int W) {
        // base condition
        if (n == 0 || W == 0) {
            return 0;
        }

        // choice diagram
        if (weight[n - 1] <= W) {
            // 2 choices whether i add into knapsack or not
            return Math.max((value[n - 1] + knapsack(weight, value, n - 1, W - weight[n - 1])), knapsack(weight, value, n - 1, W));
        } else {
            return knapsack(weight, value, n - 1, W);
        }
    }


    // 2nd Memoization [Top-Down]   TC : O(n*w)   SC : O(n*w)
    // we have to make Matrix of changeable values (of Input)
/*
    static int[][] t;
    public static int knapsack(int[] weight, int[] value, int n, int W) {
        // base condition
        if (n == 0 || W == 0) {
            return 0;
        }
        // check if it is valid(-1) or not , if it is valid -> return it
        if (t[n][W] != -1) {
            return t[n][W];
        }

        // choice diagram
        if (weight[n - 1] <= W) {
            // 2 choices whether i add into knapsack or not
            // Return the maximum of two cases: (1) nth item included (2) not included
            t[n][W] = Math.max((value[n - 1] + knapsack(weight, value, n - 1, W - weight[n - 1])), knapsack(weight, value, n - 1, W));
            return t[n][W];
        } else { // (weight[n - 1] > W)
            t[n][W] = knapsack(weight, value, n - 1, W);
            return t[n][W];
        }
    }
*/

    // Tabulation [Bottom-up]  TC : O(n*w)   SC : O(n*w)
/**
    -> Initialize base case
    -> choice diagram [changing parameter (reverse iteration)]
    -> copy the recurrence
*/
    // Using 2-D Array to store the Overlapping sub-problems.
    // Traversing the whole array to find the solution and storing in table.
    public static int knapsackBottomUp(int[] weight, int[] value, int W, int n) { // TC : O(n*W) , SC : O(n*W)
        // by default all the ele of arrays are 0. so we don't need to initialize 1st row * col
        //[1] Recursion fun Base Condition --> Top-Down Initialisation

        int[][] t = new int[n + 1][W + 1];
        //[2] Choice Diagram --> Iterative(loop)

        //Initialize 1st row as 0, n = 0 is possible with all eles
        for (int i = 0; i <= W; i++) // If n is 0 , then answer is false
            t[0][i] = 0;

        // Initialize 1st column as 0, sum = 0 is possible with all elements.
        for (int i = 0; i <= n; i++) // If sum is 0, then answer is true
            t[i][0] = 0;

        //[Choice diagram] Fill the t table in bottom up manner
        for (int i = 1; i <= n; i++) {        // i -> n ,  w -> W
            for (int j = 1; j <= W; j++) {
                if (weight[i - 1] <= j) {  // weight[n - 1] <= W
                    t[i][j] = Math.max(value[i - 1] + t[i - 1][j - weight[i - 1]], t[i - 1][j]);
                } else { // weight[n - 1] > j
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][W]; // last ele. of the Matrix will be Ans and we return it
    }

    // [Space optimized approach] Optimized Tabulation (Bottom up)    TC : O(n*w)   SC : O(n)
    public static int knapsackOptimized(int[] weight, int[] value, int n, int W) { // TC : O(n*W) , SC : O(2*W)
        // by default all the ele of arrays are 0. so we don't need to initialize 1st row * col
        //[1] Recursion fun Base Condition --> Top-Down Initialisation

        int[][] t = new int[2][W + 1];

        //Initialize 1st row as 0, n = 0 is possible with all eles
        for (int i = 0; i <= W; i++) // If n is 0 , then answer is false
            t[0][i] = 0;

        // Initialize 1st column as 0, sum = 0 is possible with all elements.
        for (int i = 0; i < 2; i++) // If sum is 0, then answer is true
            t[i][0] = 0;

        //[2] Choice Diagram --> Iterative(loop)
        // We start traversing from 2nd ele. because we have already initialize 1st row & col
        for (int i = 1; i <= n; i++) {        // i -> n ,  w -> W
            for (int j = 1; j <= W; j++) {
                if (weight[i - 1] <= j) {  // weight[n - 1] <= j
                    t[i % 2][j] = Math.max(value[i - 1] + t[(i - 1) % 2][j - weight[i - 1]], t[(i - 1) % 2][j]);
                } else { // weight[n - 1] > j
                    t[i % 2][j] = t[(i - 1) % 2][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(t));
        return t[n % 2][W]; // last ele. of the Matrix will be Ans and we return it
    }

    public static void main(String[] args) {
//        int[] wight = {2,3,4,2,1};
//        int[] value = {4,6,8,4,2};

//        int[] wight = { 10, 20, 30 };
//        int[] value =  { 60, 100, 120 };
//        int W = 50, n = value.length; // 220

        int[] wight = {2, 1, 2};
        int[] value = {4, 4, 2};
        int W = 3, n = 3; // 8

        //-> Memoization (Top down)
//        t = new int[n + 1][W + 1];
        //-> initialize all the eles of the Matrix -1
//        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));
//        int result = knapsack(wight, value, W, n);

        //-> Tabulation (Bottom up)
//        int result = knapsackBottomUp(wight, value, W, n);

        //-> optimized SC
        int result = knapsackOptimized(wight, value, n, W);
        System.out.println(result); // 8
    }

    // Optimized Tabulation [Bottom up]

//            [[0, 0, 0, 0], 1st
//             [0, 0, 4, 4]] 2nd   // we solve 2nd row using result of 1st row

//            [[0, 4, 4, 8], 3rd   // similarly 3rd row, here I won't need the res of 1st row, so I reuse the 1st for storing
//             [0, 0, 4, 4]] 2nd                                                                        // res of 3rd row

//            [[0, 4, 4, 8], 3rd
//             [0, 4, 4, 8]] 4th

}
