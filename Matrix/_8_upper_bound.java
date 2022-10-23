package Matrix;

public class _8_upper_bound {
    public static int upper_bound(int[] arr, int target) { // TC : theta(logn)
        // Initialise starting index and ending index
        int left = 0, right = arr.length - 1;
        // Till left is less than right
        while (left < right && left != arr.length) {
            // Find the index of the middle element
            int mid = left + (right - left) / 2;

            // If arr[mid] <= target, then find in right subarray
            if(arr[mid] <= target) {
                left = mid + 1;
            }

            // If arr[mid] > target then find in left subarray
            else {
                right = mid;
            }
        }
        if (left == arr.length){
            System.out.println("The upper bound of " + target + " does not exist.");
        }
        else{
            System.out.println("The upper bound of " + target + " is " + arr[left] + " at index " + left);
        }
        return left;
    }

    public static int recursive_upper_bound(int[] arr, int left, int right, int target) {
        // base condition
        if(left > right || left == arr.length) {
            return left;
        }
        // find middle index
        int mid = left + (right - left) / 2;

        // if arr[mid] <= target , then find in right subarray
        if(arr[mid] <= target) {
            return recursive_upper_bound(arr, mid + 1, right, target);
        }

        // if arr[mid] > target, then find in left subarray
        else {
            return recursive_upper_bound(arr, left, mid - 1, target);
        }
    }
    // Method to find upper bound
//    public static void upper_bound(int arr[], int target) {
//        int low = 0;
//        int high = arr.length;
//
//        // Call recursive upper bound method
//        int upperBound = recursive_upper_bound(arr, low, high, target);
//
//        if (upperBound == arr.length) {
//            System.out.println("The upper bound of " + target + " does not exist.");
//        }
//        else {
//            System.out.println("The upper bound of " + target + " is " + arr[upperBound] + " at index " + upperBound);
//        }
//    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 30, 40, 50};
//        System.out.println(upper_bound(arr,30));
        upper_bound(arr, 10);
        upper_bound(arr, 20);
        upper_bound(arr, 30);
        upper_bound(arr, 40);
        upper_bound(arr, 50);
        upper_bound(arr, 60);
    }
}
