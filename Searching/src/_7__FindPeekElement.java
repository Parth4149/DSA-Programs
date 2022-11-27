import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// find peek element (not smaller than neighbours)
public class _7__FindPeekElement {
/**
    // basic approach
    public static int getPeek(int[] arr) { // TC : O(n)
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[arr.length-1] > arr[arr.length-2]) {
            return arr.length - 1;
        }
        for (int i = 1; i < (arr.length - 1); i++) {
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                return i;
            }
        }
        return -1;
    }
*/
    //  Binary search
    public static int getPeek(int[] arr) {   // TC : O(logn)
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            // check mid is prev and next ele or not
            if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] >= arr[mid + 1])) {
                return mid;                                                             // 1st mid-1  and 2nd mid+1 check
            }
            //  if arr[mid - 1] > arr[mid] then we simply move left side
            if (mid > 0 && arr[mid - 1] > arr[mid]) {  // mid > 0 is necessary otherwise it throws an Exception
                right = mid - 1;                            // OR  if(mid < arr.length-1 && arr[mid] < arr[mid+1])  left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr={5,10,12,15,7};
//        int[] arr={3,4,5,6,7,2,1};
//        int[] arr={15,10,20,15,7};
        System.out.println(getPeek(arr));
        System.out.println(getPeek(new int[]{34, 45, 46,35,46,56}));
    }
}
