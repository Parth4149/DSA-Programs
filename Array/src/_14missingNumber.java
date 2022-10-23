import java.util.Arrays;

public class _14missingNumber {
    public static int missingNumber(int[] nums) { // Cycle sort
        int i = 0, n = nums.length;
        while(i < n) {
            int correct = nums[i];
            if(correct < n && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        // after sort an array, we find the missing number
        for(i = 0; i < n; i++) {
            if(nums[i] != i) {
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
//        System.out.println(4^4);
//        System.out.println(4^4^2^3);
//        System.out.println(2^3);
//        System.out.println(3^1^0);
        int[] arr = {3,0,1};
//        int[] arr = {0,1};
        System.out.println(missingNumber(arr));
    }


}
