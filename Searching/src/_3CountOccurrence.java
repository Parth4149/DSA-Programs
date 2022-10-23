
public class _3CountOccurrence {
//    public static int countOccurrence(int[] arr,int target) {
//        if(arr.length==0)
//            return 0;
//        int low = 0,high = arr.length-1;
//        while(low <= high) {
//            int mid = (low+high)/2; // OR mid=low+((high-low)/2)
//            if(target < arr[mid]) {
//                high = mid - 1;
//            }
//            if(target > arr[mid]) {
//                low = mid + 1;
//            }
//            else{
//                if(mid == 0 || arr[mid - 1] != arr[mid]){// first occurrence, first condition is important otherwise it throws an Exception
//                    int count = 1;
//                    while(mid < arr.length - 1 && arr[mid] == arr[mid + 1]){ // OR we can use last-first occurrence algorithm
//                        mid++;
//                        count++;
//                    }
//                    return count;
//                }
//                else{
//                    high = mid-1;
//                }
//            }
//        }
//        return -1;
//    }
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
    public static int countOccurrence(int[] arr,int target) {
        return last(arr, target) - first(arr, target) + 1;
    }
    public static void main(String[] args){
        int[] arr = {10,20,20,20,30,30};
//        int[] arr={10,10,10,10,10};
//        int res = countOccurrence(arr,10);
        int res = countOccurrence(arr,20);
        System.out.println(res);
    }
}
