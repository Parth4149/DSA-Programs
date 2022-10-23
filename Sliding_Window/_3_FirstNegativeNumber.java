package Sliding_Window;

import java.util.ArrayList;
import java.util.List;

// First Negative Number in every window
// if there is no any negative number in window, then print 0

public class _3_FirstNegativeNumber {
//    public static void printFirstNegative(int[] arr, int k) { // TC : O((n-k) * k)
//        for(int i = 0; i < (arr.length - k + 1); i++) {
//            boolean printed = false;
//            for(int j = 0; j < k; j++) {
//                if(arr[i + j] < 0) {
//                    System.out.print(arr[i + j]+" ");
//                    printed = true;
//                    break;
//                }
//            }
//            if(!printed){
//                System.out.print(0+" ");
//            }
//        }
//    }

    // using fixed size sliding window
    public static void printFirstNegative(int[] arr, int k) { // TC : O(n) , SC : O(m) where m is the no. of negative elements
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(j < arr.length) {
            // calculation
            if(arr[j] < 0) {
                list.add(arr[j]);
            }

            // check if window side < k
            else if((j - i + 1) < k) {
                j++;
            }

            // hits window size (j - i + 1) == k
            else {
                // print
                if(list.isEmpty()) {
                    System.out.print("0"+" ");
                } else {
                    System.out.print(list.get(0)+" ");
                }

                // slide the window
                if(!list.isEmpty() && arr[i] == list.get(0)) {
                    list.remove(0);
                }
                i++; j++;
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {-2,-5,7,3,-1,5,-3};
        int[] arr = {2,-5,7,3,-1,5,-3}; // -5 -5 -1 -1 -1
//        int[] arr = {1,3,-7,2,10,5,15};
//        int[] arr = {1,3,7,2,10,5,15};
//        int[] arr = {-1,-3,-7,-2,-10,-5,-15};
        printFirstNegative(arr,3);
    }
}
