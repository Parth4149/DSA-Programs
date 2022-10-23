// Union of two sorted array
public class _6__Union_Of_two_sorted_arr {

//    public static void unionTwoArray(int[] a, int[] b){ time : O(m + n)     space : O(m+n)
//        int[] c = new int[a.length + b.length];
//        for(int i = 0; i < a.length; i++){
//            c[i] = a[i];
//        }
//        for(int i = 0; i < b.length; i++){
//            c[i + a.length] = b[i];
//        }
//        Arrays.sort(c);
//        for(int i = 0; i < c.length; i++){
//            if(i == 0 || c[i] != c[i - 1]){
//                System.out.print(c[i]+" ");
//            }
//        }
//    }

    public static void unionTwoArray(int[] a, int[] b) {
        int i = 0, j = 0;
        while(i < a.length && j < b.length) {  // merging algorithm
            if(a[i] <= b[j]){
                System.out.print(a[i]+" ");
                while(i < (a.length - 1) && a[i] == a[i + 1]) {
                    i++;
                }
                i++;
            }
            else {
                // if array b has same element as present in array a then we don't print again
                if(i > 0 && b[j] != a[i - 1]) {
                    System.out.print(b[j]+" ");
                }
                while(j < (b.length - 1) && b[j] == b[j + 1]) {
                    j++;
                }
                j++;
            }
        }
        // handling remaining array (it may be possible one of the array is not complete)
        while(i < a.length) {
            if(i > 0 && a[i] != a[i - 1]) {
                System.out.print(a[i]+" ");
            }
            while(i < (a.length - 1) && a[i] == a[i + 1]) {
                i++;
            }
            i++;
        }
        while(j < b.length) {
            if(j > 0 && a[i - 1] != b[j]) {  // if array b has same element as present in array a then we don't print again
                System.out.print(b[j]+" ");
            }
            while(j < (b.length - 1) && b[j] == b[j + 1]) {
                j++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        int[] a = {2,3,3,3,4,4};
        int[] b = {2,5,7};
        unionTwoArray(a, b); // 2,3,4,5,7
    }
}
