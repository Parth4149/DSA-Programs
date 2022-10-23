package Sliding_Window;

import java.util.ArrayList;
import java.util.Arrays;

public class _2__isSubArraySum {
    // This solution is not perform for negative element it is only for positive element
    public static boolean isSum(int[] arr, int target) {
        int curr_sum = 0;
        int i = 0, j = 0;
        while(i < arr.length && j < arr.length) {
            // calculation
            curr_sum += arr[j];

            if(curr_sum < target) {
                j++;
            }
            else if(curr_sum == target) {
                return true;
            }
            else { // curr_sum > target
                // i need to start subtract eles from beginning of the curr window until curr_sum becomes <= target
                while(curr_sum > target) {
                    curr_sum -= arr[i];
                    i++;
                }
                if(curr_sum == target) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static ArrayList<Integer> subarraySum(int[] arr, int n, int target) { // return the starting & ending position
        int i = 0, j = 0;
        int curr_sum = 0;
        while(j < n) {
            // cal
            curr_sum += arr[j];

            if(curr_sum < target) {
                j++;
            }

            else if(curr_sum == target) {
                return new ArrayList<>(Arrays.asList(i + 1 , j + 1));
            }

            else {
                System.out.println(curr_sum);
                while(curr_sum > target) {
                    curr_sum -= arr[i];
                    i++;
                }
                if(curr_sum == target) {
                    return new ArrayList<>(Arrays.asList(i + 1 , j + 1));
                }
                j++;
            }
        }
        return new ArrayList<>(Arrays.asList(0, 0));
    }

    public static boolean isSubString(String str, String target) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while(j < str.length()){
            // calculation
            sb.append(str.charAt(j));

            if(sb.length() < target.length()){
                j++;
            }
            else {                                                  // sb.length() == target.length()
                if(target.equals(String.valueOf(sb))) {
                    return true;
                } else {
                    sb.delete(0,1);
                }
                j++;
            }
        }
//        int s = 0;
//        for(int i = 1; i < str.length(); i++){
//            if(sb.length() > target.length()){
//                sb.delete(s,s+1);
//                s++;
//            }
//            if(sb.equals(target)){
//                return true;
//            }
//            sb.append(str.charAt(i));
//        }
        return false;
    }
    public static void main(String[] args) {
//        int[] arr = {1,4,20,3,10,5};
//        int[] arr = {2,3,5,7,2,1,8};
//        int[] arr = {12,2,3,7,5};
        int[] arr = {8,2,3,5,7,1,9};
        boolean ans = isSum(arr,12);
        System.out.println(ans);

        int[] arr2 = {1,2,3,7,5}; // [2, 4]
        System.out.println(subarraySum(arr2,5,12));

        System.out.println(isSubString("TheQuickBrown","Quick"));


//        StringBuilder s = new StringBuilder();
//        s.append("TheQuick");
//        StringBuilder t = new StringBuilder("TheQuick");
//        String t1 = "TheQuick";
//        System.out.println(t1.equals(String.valueOf(s)));
//        System.out.println(s);
//        s.delete(0,1);
//        System.out.println(s);

    }
}
