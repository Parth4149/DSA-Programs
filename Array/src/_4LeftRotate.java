import java.util.Arrays;

public class _4LeftRotate {
    public static void leftRotate(int[] arr) { // time : theta(n)
        if (arr.length == 0) {
            return;
        }
        int temp = arr[0]; // save first element in tmep
        int i;
        for (i = 0; i < (arr.length - 1); i++) {
            arr[i] = arr[i + 1];
        }
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        leftRotate(arr);
        System.out.println(Arrays.toString(arr));
    }
}
