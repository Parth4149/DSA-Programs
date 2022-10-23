package DP;

public class _2_0_Unbounded_Knapsack {
    // Recursion        TC : O(2^(w))
    public static int unboundedKnapsack(int[] wt, int[] val, int n, int w) {
        // base condition
        if(n == 0 || w == 0) {
            return 0;
        }

        // choice diagram
        // There are two cases either take element or not take.
        if(wt[n - 1] <= w) {
            return Math.max(val[n-1] + unboundedKnapsack(wt, val, n,w - wt[n-1]) ,
                            unboundedKnapsack(wt, val,n-1, w));
        } else {
            return unboundedKnapsack(wt, val, n - 1, w);
        }
    }
    public static void main(String[] args) {
        int[] weight = {2,3,4,2};
        int[] value = {4,6,8,3};
        int n = weight.length, W = 10;
//        int W = 100;
//        int[] value = { 10, 30, 20 };
//        int[] weight = { 5, 10, 15 }; // 300
//        int n = value.length;
        int result = unboundedKnapsack(weight, value, n, W);
        System.out.println(result); //
    }
}
