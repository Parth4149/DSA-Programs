
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

    // upper bound return index of next smallest no which is >= target
    // if no such element is found, it will print upper bound does not exist.
    public static int upper_bound(int[] arr, int target) {
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
                    return mid + 1; // last occurrence + 1
                } else {
                    left = mid + 1;
                }
            }
        }
        if (left == arr.length) {
            System.out.println("Upper bound does not exist");
        }
        return left;
    }

    // lower bound return index of 1st occurrence of target if target exist, otherwise next smallest no which is >= target
    public static int lower_bound(int[] arr, int target) {
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
        return left;
    }


    public static void main(String[] args) {
        int[] arr = {1,10,10,10,20,20,40};
//        int[] arr={1,10,10,10};
//        int[] arr = {10,20,30,30,40,50};

        System.out.println(first(arr,10)); // 1
        System.out.println(last(arr,10)); // 3

        System.out.println(lower_bound(arr, 10)); // 1
        System.out.println(upper_bound(arr, 10)); // 4
    }
}
