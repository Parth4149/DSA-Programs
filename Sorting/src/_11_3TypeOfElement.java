import java.util.Arrays;

public class _11_3TypeOfElement {
/**
    public static void sort(int[] arr) {  // TC : theta(n) , SC : theta(n)
        int[] temp = new int[arr.length];
        int i = 0;
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] == 0) {
                temp[i++] = arr[j];
            }
        }
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] == 1) {
                temp[i++] = arr[j];
            }
        }
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] == 2) {
                temp[i++] = arr[j];
            }
        }
        for(int j = 0; j < arr.length; j++) {
            arr[j] = temp[j];
        }
    }
*/
// [1,2,0,1,1,2]
    public static void sort012(int[] arr) {     // Dutch National Flag Algorithm(0,1,2)  // TC : theta(n) , SC : theta(1)
        int l = 0, r = arr.length - 1, m = 0;
        // l is maintaining orders of 0 , similarly m (1)  , r (2)
        while(m <= r) {
            if(arr[m] == 0) {    // increment l and m
                swap(arr, l, m);
                l++;
                m++;
            }
            // here previous elements of m always <= 1 so that we increment l and m
            else if(arr[m] == 1) { // only m will increment
                m++;
            }
            else {       //  swap with r
                swap(arr, m, r);
                r--;
            }
        }
        System.out.println(l+" "+m+" "+r);
    }
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // negative element moves left and positive element moves right
    public static void partition(int[] arr) {// Dutch National Flag Algorithm(0,1,2)  // TC : theta(n) , SC : theta(1)
        int l = 0, r = arr.length - 1, m = 0;
        while(m <= r){
            if(arr[m] < 0){
                swap(arr, l, m);
                l++; m++;
            }
            else if(arr[m] == 0){
                m++;
            }
            else{
                swap(arr, r, m);
                r--;
            }
        }
    }
    //----------------------------------------------------------------------------------------------------------------
    public static void partition3Way(int[] arr, int target){
        int p = lPartition(arr, target);
//        int p = hPartition(arr, target);
        int i = p;
        for(int j = p + 1; j < arr.length; j++){
            if(arr[j] == target){
                i++;
                swap(arr,i, j);
            }
        }
    }
    public static int lPartition(int[] arr, int pivot){
        // here pivot may not be place at last position, so that we have to move pivot at last position
        for(int j = 0; j < arr.length; j++){ // move pivot at last
            if(arr[j] == pivot){
                swap(arr, j, (arr.length - 1));
                break;
            }
        }
        // after moving pivot at last position we assign last element as pivot
        pivot = arr[arr.length - 1];
        int i = 1;
        for(int j = 0; j < arr.length - 1; j++){
            if(arr[j] < pivot){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, (arr.length - 1));
        return i;
    }

    public static int hPartition(int[] arr, int pivot){
        for(int j = 0; j < arr.length; j++){ // move pivot at first position
            if(arr[j] == pivot){
                swap(arr, j, 0);
                break;
            }
        }
        // after moving pivot at last position we assign first element as pivot
        pivot = arr[0];
        int i = 0, j = arr.length - 1;
        // iterate the array
        while(true) {
            while(arr[i] < pivot) {
                i++;
            }

            while(arr[j] > pivot) {
                j--;
            }
            if(i >= j) {
                return j;               // return index of left subArray
            }
            swap(arr,i, j);
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,0,1,1,2};
//        int[] arr = {1,1,0,2,1,0};
        int[] arr = {2,0,2,1,1,0};
        sort012(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {5,2,10,2,1,20,1};
        partition3Way(arr2,5);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {0,5,-4,10,-10,0,15,-4,66};
        partition(arr3);
        System.out.println(Arrays.toString(arr3));

    }
}
