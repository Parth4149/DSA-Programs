import java.util.Arrays;

public class _5_UnboundedSearch {
    // Unbounded Binary Search for infinite number of array
    public static int Search(int[] nums,int target) {
        int left = 0, right = 1;
        while(target > nums[right]) {
            left = right;
            right = right * 2;
        }
        return binarySearch(nums, target, left, right);
    }
    public static int binarySearch(int[] arr,int target, int left, int right) {    // O(logn)
        while(left <= right) {
            int mid = left + ((right-left) / 2);//we calculate int m = l + (r - l)/2; rather than int m = (l + r)/2; to avoid overflow.
            if(arr[mid] == target) {
                return mid;
            }
            if(target < arr[mid]) {
                right = mid - 1;
            }
            if(target > arr[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr={1,2,2,3,3,4,5,6,6,7,8,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,10,11,23};
        int[] arr={1,2,2,3,4,5,7,9,9,10,11,23};
        System.out.println(Search(arr,9)); //
        System.out.println(Search(arr,1)); //
    }
}
