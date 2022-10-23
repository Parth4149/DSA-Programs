// Median of two sorted arrays
public class _10__Median {

    public static double median(int[] a1, int[] a2) {  // TC : theta(((m + n)/2) + 1) = theta(m + n)
        int i = 0, j = 0;
        int midIndex = (a1.length + a2.length) / 2;
        int midElement = 0;
        int prevMid = 0; // stores the previous element of middle element
        // if( (m+n) % 2 == 0) here there is two middle  in this case we consider average of two middle
        while(i < a1.length && j < a2.length && (i + j) <= midIndex) {   // add (i + j) <= midIndex) , to traverse up to midIndex element
            prevMid = midElement;
            if(a1[i] <= a2[j]) {
                midElement = a1[i++];
            } else{
                midElement = a2[j++];
            }
        }
        while(i < a1.length && (i + j) <= midIndex) {
            prevMid = midElement;
            midElement = a1[i++];
        }
        while(j < a2.length && (i + j) <= midIndex) {
            prevMid = midElement;
            midElement = a2[j++];
        }

        if(((a1.length + a2.length) & 1) == 1) {  // odd
            return midElement;
        } else {                                 // even
            return (prevMid + midElement) / 2.0;
        }
    }

//    public static double median2(int[] A, int[] B) { // TC : theta( log(max-min) * (2*log(max(m,n)) , SC : theta(1)
//        // base condition if one of length is 0, we return middle element
//        if(A.length == 0) {
//            if((B.length & 1) == 1) // odd
//                return B[B.length / 2];
//            else // even
//                return (B[(B.length - 1) / 2] + B[B.length / 2]) / 2.0;
//        }
//        else if(B.length == 0) {
//            if((A.length & 1)== 1) // odd
//                return A[A.length / 2];
//            else
//                return (A[(A.length - 1) / 2] + A[A.length / 2]) / 2.0;
//        }
//
//        int m = A.length, n = B.length;
//        int l = (m + n + 1) / 2; // left mid
//        int r = (m + n + 2) / 2; // right mid
//        return (getMedian(A, B, l) + getMedian(A, B, r)) / 2.0;
//    }

//    private static double getMedian(int[] A, int[] B, int desired_counter) {
//        // find min and max from given matrix
//        int min = Math.min(A[0], B[0]);
//        int max = Math.max(A[A.length - 1], B[B.length - 1]);
//        // binary search
//        while(min < max) {
//            int counter = 0;
//            int middle = min + (max - min) / 2;
////            System.out.println(min +" " + max);
//            counter += upper_bound(A, middle);
//            counter += upper_bound(B, middle);
//
//            if(counter < desired_counter) {
//                min = middle + 1;
//            } else {
//                max = middle;
//            }
//        }
//        return min;
//    }


//    public static int upper_bound(int[] arr, int target){
//        // Initialise starting index and ending index
//        int left = 0, right = arr.length - 1;
//        // Till left is less than right
//        while (left < right && left != arr.length) {
//            // Find the index of the middle element
//            int mid = left + (right - left) / 2;
//
//            // If arr[mid] <= target, then find in right subarray
//            if(arr[mid] <= target) {
//                left = mid + 1;
//            }
//
//            // If arr[mid] > target then find in left subarray
//            else {
//                right = mid;
//            }
//        }
//        return left;
//    }

    public static void main(String[] args) {
//        int[] a1 = {10,20,30,40};
//        int[] a2 = {7,25,32,50};  // [7,10,20,25,30,32,40,50]
        int[] a1 = {1,2};
        int[] a2 = {3,4};
//        int[] a1 = {};
//        int[] a2 = {2,3};
        double ans = median(a1, a2);
        System.out.println(ans);
    }
}
