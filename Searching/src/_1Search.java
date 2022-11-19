public class _1Search {

    public static int Search(int[] arr, int left, int right, int target) {// time : O(logn) , space : O(logn)    (overhead O(1))

        int mid = left + ((right - left) / 2);

        if (left > right) {
            return -1;
        }
        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return Search(arr, left, mid - 1, target);
        } else {
            return Search(arr, mid + 1, right, target);
        }
    }


    /**
     * To get the middle value, but this can cause OVERFLOW !
     * when start and end are all about INT_MAX , then (start+end) of course will be overflow !
     * To avoid the problem we can use
     * mid = low + ((high-low) / 2)
     */
    public static int Search(int[] arr, int target) {// O(logn)
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);//we calculate int m = l + (r - l)/2; rather than int m = (l + r)/2; to avoid overflow.
            if (arr[mid] == target) {
                return mid;
            }
            if (target < arr[mid]) {
                high = mid - 1;
            }
            if (target > arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};

//        System.out.println(Search(arr,10));// total comparison : 3
//        System.out.println(Search(arr,20));// total comparison : 2
//        System.out.println(Search(arr,30));// total comparison : 3
//        System.out.println(Search(arr,40));// total comparison : 1
//        System.out.println(Search(arr,50));// total comparison : 3
//        System.out.println(Search(arr,60));// total comparison : 2
//        System.out.println(Search(arr,70));// total comparison : 3

//        System.out.println(Search(arr,0,6,10));
//        System.out.println(Search(arr,0,6,70));
    }
}
