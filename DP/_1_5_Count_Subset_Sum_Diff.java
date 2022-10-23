package DP;

// Count the number of subset with a given difference
public class _1_5_Count_Subset_Sum_Diff {
    // Recursion
    public static int countSubsetSumDiff(int[] arr, int target, int n) {
        int totalSum = 0;
        for(int i : arr) {
            totalSum += i;
        }
            // sum(s1) - sum(s2) = target   ---- 1  [our goal (count)]
            // sum(s1) + sum(s2) = totalSum ---- 2  [we know]
            //  2sum(s1) = target + totalSum        [solve 2 equations]
        int sum = (target + totalSum) / 2;
        return countSubsetSum(arr, n, sum);
    }

    public static int countSubsetSum(int[] set, int n, int sum) {
        // base condition
        if(sum == 0)
            return 1;

        if(n == 0)
            return 0;

        // choice diagram
        if(set[n - 1] <= sum) {
            return countSubsetSum(set,n - 1, sum - set[n - 1]) + countSubsetSum(set,n - 1, sum);
        } else {
            return countSubsetSum(set,n -1, sum);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3}; // 3
        int n = arr.length;
        int res = countSubsetSumDiff(arr,1, n);
        System.out.println(res);
    }
}
