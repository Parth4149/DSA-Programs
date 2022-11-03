package DP;

// Longest Increasing Subsequence | Binary Search
public class _5_1_1_LIS_Binary_Search {
/*
    (1) if x is larger than all tails, append it, increase the size by 1
    (2) if tails[i-1] < x <= tails[i], update tails[i]
*/
    public static int longestIncreasingSubsequence(int[] arr) { // TC : O(n * logn) , SC : O(n)
        int[] tails = new int[arr.length];
        tails[0] = arr[0]; // set 1st ele
        int size = 1;
        // iterating array from 2nd ele
        for (int i = 1; i < arr.length; i++) { // arr[i] = x
            if (arr[i] > tails[size - 1]) {
                tails[size++] = arr[i];
            } else {
                int ind = lower_bound(tails, arr[i], 0, size - 1);
                tails[ind] = arr[i];
            }
        }
        return size;
    }

    // lower bound return index of 1st occurrence of target if target exist, otherwise next smallest no which is >= target
    public static int lower_bound(int[] arr, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target < arr[mid]) {
                right = mid - 1;
            }
            else if(target > arr[mid]) {
                left = mid + 1;
            }
            else {
                if(mid == 0 || arr[mid - 1] != arr[mid]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18}; // 4
//        int[] arr = {0,1,0,3,2,3}; // 4
//        int[] arr = {7,7,7,7,7,7,7}; // 1
        int ans = longestIncreasingSubsequence(arr);
        System.out.println(ans);
    }
}
