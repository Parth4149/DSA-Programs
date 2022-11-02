package DP;

import java.util.ArrayList;

// Longest Increasing Subsequence | Binary Search
public class _5_1_1 {

    public static int longestIncreasingSubsequence(int[] arr) { // TC : O(n * logn) , SC : O(n)
        ArrayList<Integer> list = new ArrayList<>();
        int len = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
                len++;
            } else {
                int ind = lower_bound(arr, arr[i]); // here we need to pass list
                list.set(ind, arr[i]);
            }
        }
        return len;
    }

    // lower bound return index of 1st occurrence of target if target exist, otherwise next smallest no which is >= target
    public static int lower_bound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
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
//        int[] arr = {10,20,30,30,40,50};
//        int[] arr = {10,20,30,40,50};
        int[] arr = {1,4,5,4,28};
        int ans = longestIncreasingSubsequence(arr);
        System.out.println(ans);
    }
}
