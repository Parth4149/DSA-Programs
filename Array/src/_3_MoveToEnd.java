import java.util.Arrays;

public class _3_MoveToEnd {      // move all zeros to end
    public static void moveAllZeros(int[] arr){// time : O(n)
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                swap(arr ,i, count);
                count++;
            }
        }
    }

    static void binarySort(int[] arr){ // similar move to zero (here move all 1 to end)
        // add your code here
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                swap(arr, i, count);
                count++;
            }
        }
    }
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
//        int[] arr={0,0,0,7,0};
//        int[] arr={7,8};
        int[] arr={0, 3, 0, 4, 0, 0, 7};
        moveAllZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
