import java.util.Arrays;

public class _10_Segregate {
/**   // Naive approach
    public static void segregatePosNeg(int[] arr){  // TC : O(n) , SC : O(n)
        int[] temp = new int[arr.length];
        int i = 0;
        for(int j = 0; j < arr.length; j++){    // first store negative number
            if(arr[j] < 0){
                temp[j] = arr[i++];
            }
        }
        for(int j = 0; j < arr.length; j++){    // store positive number
            if(arr[j] > 0){
                temp[j] = arr[i++];
            }
        }
        for(int j = 0; j < arr.length; j++){   // store in arr
            arr[i] = temp[i];
        }
    }
*/
//------------------------------------------------------------------------------------------------------------------
    public static void segregatePosNeg(int[] arr){ // segregate(separate) positive and negative
        int i = 0;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] < 0){
                swap(arr, i, j);
                i++;
            }
        }
    }
    // another efficient approach
    public static void segregatePosNeg2(int[] arr){ // Hoare Partition    , TC : theta(n) , SC : theta(1)
        int i = 0, j = arr.length -1;
        while(true) {
            while(arr[i] < 0) {
                i++;
            }
            while(arr[j] > 0) {
                j--;
            }

            if(i >= j){
                return;
            }
            swap(arr, i, j);
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void segregateEvenOdd(int[] arr){ // segregate(separate) even and odd
        int i = 0;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] % 2 == 0){
                swap(arr, i, j);
                i++;
            }
        }
    }
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
//        int[] arr = {5,-3,10,-7};
//        segregatePosNeg2(arr);

        int[] arr = {5,10,6,3,15,12};
        segregateEvenOdd(arr);

        System.out.println(Arrays.toString(arr));

    }
}
