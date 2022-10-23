public class _4SquareRoot {
//    public static int sqrt(int num) { // time : O(logn)
//        int low = 0, high = num, ans = -1;
//        while(low <= high) {
//            int mid = (low + high) / 2;
//            int midSquare = mid * mid;
//            if(midSquare == num) {
//                return mid;
//            }
//            if(num < midSquare) {
//                high = mid - 1;
//            }
//            else {
//                low = mid + 1;
//                ans = mid; // it computes closet sqrt of number e.g. 27 -> 5,  here 25 is closet to 27
//            }
//        }
//        return ans;
//    }
    public static int sqrt(int num) {
        int left = 0, right = num / 2;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midSquare = mid * mid;
            if(num == midSquare) {
                return mid;
            }
            else if(num < midSquare) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        System.out.println(sqrt(25)); // 5
        System.out.println(sqrt(27)); // 5
        System.out.println(sqrt(42)); // 6
    }
}
