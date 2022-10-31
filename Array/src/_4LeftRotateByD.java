import java.util.Arrays;

public class _4LeftRotateByD {
    /*
     public static void leftRotate(int[] arr,int d){// time : theta(d+n-d+d) = theta(n+d) = theta(n) ,  space : theta(d)
         int[] temp = new int[d];
         for(int i=0; i<d; i++){     // store first d elements in temp
             temp[i] = arr[i];
         }
         for(int i=d; i<arr.length; i++){    // move remaining elements
             arr[i-d] = arr[i];
         }
         for(int i=0; i<d; i++){
             arr[arr.length-d+i] = temp[i];  // update next d element
         }
     }
     */

    //Efficient approach
    /**
     * if k>count, we should take reminder of k/count
     * because let us take one example
     * k=7 and count=5
     * in this case, ( generally  rotate the list by 7 places)
     * if we take 7%5 = 2 , rotate the list only by 2 places instead of 7 places
     * both gives same results, so we consider second case
     */
    public static void leftRotate(int[] arr, int k) {// time : theta(n)+theta(n)+theta(n) = theta(3n) = theta(n) , space : theta(1)

        k = k % arr.length;     // if k > arr.length then (k % n) will be reminder otherwise it throws ArrayIndexOutOfBound Exception

        reverse(arr, 0, k - 1);      // revers first k element

        reverse(arr, k, arr.length - 1);     // revers k to n

        reverse(arr, 0, arr.length - 1);     // revers whole array
    }

    public static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void reverseKGroup(int[] arr, int k) {
        for (int i = 0; i + k - 1 < arr.length; i = i + k) {
            reverse(arr, i, i + k - 1);
        }
    }


    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
//        int[] arr={1,2};
        leftRotate(arr, 3);

//        int[] arr={10,20,30,40,50,60,70,80};
//        reverseKGroup(arr,4);

        System.out.println(Arrays.toString(arr));
    }

}
