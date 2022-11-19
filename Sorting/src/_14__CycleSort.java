import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [NOTE] When given no. from range 1 to N => Use Cycle sort
 * <p>
 * In place algorithm and Not stable
 * <p>
 * e.g. given no. 1 to N  find missing no
 * find the smallest positive no
 * find duplicate no
 * find min swap required to sort an array
 */

//if the current number you are iterating is not at the correct index, you swap it with the number at its correct index.
public class _14__CycleSort {
    public static void cycleSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;  // if no. starting from 0 to n, correct = arr[i]
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct); // swap i with correct index
            } else {
                i++; // move ahead
            }
        }
    }

    /**
     * Find All Numbers Disappeared in an Array  // int[] arr = {4,3,2,7,8,2,3,1};  O/P : [5,6]
     */ // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // first we sort an array using cycle sort
        int i = 0;
        while (i < nums.length) {
            int elementIndex = nums[i] - 1;
            if (nums[i] != nums[elementIndex]) {
                swap(nums, i, elementIndex);
            } else {
                i++;
            }
        }
        i = 0;
        List<Integer> res = new ArrayList<>();
        while (i < nums.length) {
            if (nums[i] != (i + 1)) {
                res.add(i + 1);
            }
            i++;
        }
        return res;
    }

    /**
     * Find the Duplicate Number   // int[] arr = {3,1,3,4,2};    O/P : 3
     */ // https://leetcode.com/problems/find-the-duplicate-number/
    public static int findDuplicate(int[] nums) {    // TC : O(n)
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        // search for first missing no
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }

// [Note]  without modifying the array nums and uses only constant extra space.
//    public int findDuplicate(int[] nums) {  // time : O(n)    space : O(1)
//        int duplicate = -1;
//        for (int i = 0; i < nums.length; i++) {
//            int correct = Math.abs(nums[i]) - 1;  // array index starting from 0
//            if (nums[correct] < 0){
//                duplicate = correct + 1; // duplicate = Math.abs(nums[correct])
//                break;
//            }
//            nums[correct] = -nums[correct];
//        }
//
//        // Restore numbers
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = Math.abs(nums[i]);
//        }
//
//        return duplicate;
//    }


    /**
     * Find All Duplicates in an Array int[] arr = {4,3,2,7,8,2,3,1};    O/P : [2,3] OR [3,2]
     */ // https://leetcode.com/problems/find-all-duplicates-in-an-array/
    public static List<Integer> findAllDuplicates(int[] nums) { // TC : O(n) , SC : O(m) where m is no. of dup element
        List<Integer> res = new ArrayList<>();
        // first we sort an array using cycle sort
        int i = 0;
        while (i < nums.length) {
            int elementIndex = nums[i] - 1;
            if (nums[i] != nums[elementIndex]) {
                swap(nums, i, elementIndex);
            } else {
                i++;
            }
        }
        i = 0;
        // here duplicate ele will place at pos of missing ele becoz all eles lies between 1 to n
        while (i < nums.length) {  // search for duplicate no
            if (nums[i] != i + 1) {
                res.add(nums[i]);
            }
            i++;
        }
        return res;
    }

    // int[] arr = {3,0,1}; // 2
    public static int missingNumber(int[] nums) { // Cycle sort
        int i = 0, n = nums.length;
        while (i < n) {
            int correct = nums[i];
            if (correct < n && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        // after sort an array, we find the missing number
        for (i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return i; // n
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
//        int[] arr = {3,5,2,1,4};
//        int[] arr = {4,3,2,7,8,2,3,1};
//        cycleSort(arr);
//        System.out.println(Arrays.toString(arr));

//        int[] arr = {4,3,2,7,8,2,3,1};
//        System.out.println(findDisappearedNumbers(arr)); // [5,6]

//        int[] arr = {3,1,3,4,2};
//        System.out.println(findDuplicate(arr)); // 3

//        int[] arr = {4,3,2,7,8,2,3,1};
//        System.out.println(findAllDuplicates(arr)); // [2,3] OR [3,2]

//        int[] arr = {3,0,1}; // 2
//        int[] arr = {0,1}; // 2
//        System.out.println(missingNumber(arr));
    }
}
