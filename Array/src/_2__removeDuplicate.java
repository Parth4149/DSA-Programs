import java.util.Arrays;

public class _2__removeDuplicate{
    public static int removeDuplicate(int[] arr){      // time : O(n) , space(1)
        int res = 1;
        for(int i = 1; i < arr.length; i++){
//            if(arr[res - 1] != arr[i]){  // if last element is != arr[i]
//                arr[res] = arr[i];
//                res++;
//            }
            if(arr[i - 1] != arr[i]){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {10,10,20,20,30,30,30};
//        int[] arr = {5,10,10,20,20,20};
        System.out.println(removeDuplicate(arr)); // returns number of elements (we count duplicate numbers only once)
    }
}
