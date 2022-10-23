//    Search in Sorted Rotated Array
public class _6_SearchSortedRotatedArr {
//    static int count = 0;
    public static int Search(int[] nums,int target) { // time : O(logn)
        int low=0, high = nums.length-1;
        while(low <= high) {//    Like Normal Binary Search
//            count++;
            int mid = low + ((high - low)/2);
            if(target == nums[mid]) {
                return mid;
            }
            else if(nums[low] <= nums[mid]) {      // left half sorted
                if(nums[low] <= target && target <= nums[mid]) {    //
                    high = mid-1;
                } else{
                    low = mid+1;
                }
            }
            else {                              // right half sorted
                if(nums[mid] <= target && target <= nums[high]) {   //
                    low = mid+1;
                } else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
//        int[] arr={10,20,30,40,50,8,9};
//        int[] arr={3,1};
        int[] arr={4,5,6,7,0,1,2};
        System.out.println(Search(arr,0));
//        for(int i=0; i<arr.length; i++){
//            System.out.println(arr[i]+"\tindex : "+Search(arr,arr[i])+"\t count : "+count);count=0;
//        }
    }
}
