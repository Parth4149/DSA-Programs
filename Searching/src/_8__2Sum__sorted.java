public class _8__2Sum__sorted {

/**
     // Naive solution (Brute force approach)

    public static boolean pairSum(int[] arr,int target){    // time : O(n^2)
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(target == (arr[i] + arr[j])){
                    return true;
                }
            }
        }
        return false;
    }
*/
    // Efficient Solution
    public static boolean pairSum(int[] arr, int target){   // time : O(n)
        int left = 0,right = arr.length-1;
        while(left < right){
            if((arr[left] + arr[right]) == target){
                return true;
            }
            if((arr[left] + arr[right]) > target){
                right--;
            }
            if((arr[left] + arr[right]) < target){
                left++;
            }
        }
        return false;
    }
    public static boolean threePairSum(int[] arr,int target) {
        int left = 0, right = arr.length-1;
        int mid = left + (right - left) / 2;
        while(left < right){
            int sum = arr[left] + arr[mid] + arr[right];
            if(sum == target) {
                return true;
            }
            if(sum < target){
                if(mid == left)
                    mid++;
                else
                    left++;
            }
            else{
                if(mid == right)
                    mid--;
                else
                    right--;
            }
        }
        return false;
    }
    // pair sum in sorted array
    public static void main(String[] args) {
        int[] arr={2,3,4,8,9,20,40};

        System.out.println(pairSum(arr,22));

        System.out.println(threePairSum(arr,32));
    }
}
