// Median of two sorted arrays
public class _10__Median {

    public static double median(int[] a1, int[] a2) {  // TC : theta(((m + n)/2) + 1) = theta(m + n)
        int i = 0, j = 0;
        int midIndex = (a1.length + a2.length) / 2;
        int midElement = 0;
        int prevMid = 0; // stores the previous element of middle element
        // if( (m+n) % 2 == 0) here there is two middle  in this case we consider average of two middle
        while (i < a1.length && j < a2.length && (i + j) <= midIndex) {   // add (i + j) <= midIndex) , to traverse up to midIndex element
            prevMid = midElement;
            if (a1[i] <= a2[j]) {
                midElement = a1[i++];
            } else {
                midElement = a2[j++];
            }
        }
        // it may possible one of array is not complete
        while (i < a1.length && (i + j) <= midIndex) {
            prevMid = midElement;
            midElement = a1[i++];
        }
        while (j < a2.length && (i + j) <= midIndex) {
            prevMid = midElement;
            midElement = a2[j++];
        }

        if (((a1.length + a2.length) & 1) == 1) {  // odd
            return midElement;
        } else {                                 // even
            return (prevMid + midElement) / 2.0;
        }
    }

    public static void main(String[] args) {
//        int[] a1 = {10,20,30,40};
//        int[] a2 = {7,25,32,50};  // [7,10,20,25,30,32,40,50]
        int[] a1 = {1, 2};
        int[] a2 = {3, 4};
//        int[] a1 = {};
//        int[] a2 = {2,3};
        double ans = median(a1, a2);
        System.out.println(ans);
    }
}
