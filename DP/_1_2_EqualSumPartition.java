package DP;

public class _1_2_EqualSumPartition {

//    public static boolean isSubsetSum(int[] set, int n, int sum) {
//        // base condition
//        if(sum == 0)
//            return true;
//        if(n == 0)
//            return false;
//
//        // choice diagram        // here we cannot compare bool vals, so we use OR operator instead of max
//        if(set[n - 1] <= sum) {
//            // 2 choices whether i add into sum or not , if i add num, i need to subtract it in sum
//            return isSubsetSum(set,n - 1,sum - set[n-1]) || isSubsetSum(set,n - 1, sum);
//        }
//
//        else {
//            return isSubsetSum(set,n - 1, sum);
//        }
//    }

    public static boolean isSubsetSum(int[] arr, int n, int sum) { // tC : O(sum*n) , SC : O(sum*n)
        boolean[][] t = new boolean[n + 1][sum + 1];

        // base condition

        // Initialize 1st column as true, 0 sum is possible  with all elements.
        for(int i = 0; i <= n; i++) // If sum is 0, then answer is true
            t[i][0] = true;

        //Initialize 1st row as row, except 0(1st ele), no other sum except 0 is possible
        for(int i = 1; i <= sum; i++) // If n is 0 , then answer is false
            t[0][i] = false;

        //[Choice diagram] Fill the t table in bottom up manner
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }

    /** Equal Sum Partition
     * PS : find out 2 subsets whose sum is equal to target sum

     * first I need to find sum of all the ele
     * if totalSum = odd -> return false
     * if totalSum = even -> call SubsetSum function
     * My target sum is totalSum/2
     * here I need to find sum only for 1 subset, 2nd subset must be = sum/2
     */
    public static boolean isEqualSumPartition(int[] set, int n) {
        int totalSum = 0;
        for(int i = 0; i < n; i++) {
            totalSum += set[i];
        }
        if(totalSum % 2 != 0) { // If sum is odd there cannot be two subsets with equal sum
            return false;
        } else { // even
            // Find if there is subset with sum equal to half of total sum
            return isSubsetSum(set, n, totalSum / 2);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
//        int[] arr = {3, 1, 1, 2, 2, 1};
        int n = arr.length;
        boolean result = isEqualSumPartition(arr,n);
        System.out.println(result);
    }
}
