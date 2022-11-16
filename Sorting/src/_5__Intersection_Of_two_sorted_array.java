import java.util.Arrays;
import java.util.List;

// Intersection of two sorted Arrays

// Intersection of three sorted Arrays [Common elements]
// https://practice.geeksforgeeks.org/problems/common-elements1132/1

public class _5__Intersection_Of_two_sorted_array {

//    public static void intersectionArray(int[] a, int[] b) {  // time : O(n^2)
//        for(int i = 0; i < a.length; i++){
//            if(i > 0 && a[i] == a[i - 1]){// if the curr ele = pre ele , we continue the loop (continue the next iteration)
//                continue;
//            }
//            for(int j = 0; j < b.length; j++) {
//                if(a[i] == b[j]) {
//                    System.out.print(a[i]+" ");
//                    break;
//                }
//            }
//        }
//    }

    public static void intersectionArray(int[] a, int[] b) { // TC : theta(m + n)
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                System.out.print(a[i] + " ");
                // checking for repeated element so that this we don't count again
                while (i < (a.length - 1) && a[i] == a[i + 1]) {
                    i++;
                }

                while (j < (b.length - 1) && b[j] == b[j + 1]) {
                    j++;
                }

                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {3, 5, 10, 10, 10, 10, 10, 15, 15, 20};
        int[] a2 = {5, 10, 10, 15};
//        intersectionArray(a1, a2);
        intersectionArray(a1, a2);
    }
}
