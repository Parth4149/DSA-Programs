
class _2_first_and_last_occurrence {
    public static int first(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target < arr[mid]) {
                right = mid - 1;
            }
            else if(target > arr[mid]) {
                left = mid + 1;
            }
            else {
                if(mid == 0 || arr[mid - 1] != arr[mid]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int last(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + ((right - left) / 2);
            if(target < arr[mid]) {
                right = mid - 1;
            }
            else if(target > arr[mid]) {
                left = mid + 1;
            }
            else{
                if(mid == arr.length - 1 || arr[mid] != arr[mid + 1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,10,10,10,20,20,40};
//        int[] arr={1,10,10,10};
        System.out.println(first(arr,10));
        System.out.println(last(arr,10));
    }
}
