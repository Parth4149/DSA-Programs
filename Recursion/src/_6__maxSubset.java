/**
 *** SubArray/subString = n*(n+1)/2
 *** Subseqeunce = (2^n) -1 (non-empty subsequences)
 *** Subset(Power-set) = 2^n

 * A subArray is a contiguous part of array. An array that is inside another array.
 * For example:
    -> consider the array [1, 2, 3, 4], There are 10 non-empty sub-arrays.
    -> The subArrays are (1), (2), (3), (4), (1,2), (2,3), (3,4), (1,2,3), (2,3,4) and (1,2,3,4)
 */
public class _6__maxSubset {


    public static int maxSubset(int[] arr, int sum, int i){ // time : theta(2^n)
                                              // if we want to print all Subset then print the sum
        if(i == arr.length){
            return sum;
        }
        // here we use two operation, we ignore the arr[i] and take(add) it
        return Math.max(maxSubset(arr, sum,i + 1), maxSubset(arr,sum + arr[i],i + 1));
    }

//    public static int maxSubset(int[] arr, int sum){
//
//    }
    public static void main(String[] args) {
        int[] arr = {5,6,7};
        System.out.println(maxSubset(arr,0,0));
    }
}
