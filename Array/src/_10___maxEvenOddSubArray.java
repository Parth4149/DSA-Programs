public class _10___maxEvenOddSubArray {
    /**
    public static int maxEvenOddSubArray(int[] nums){// time : O(n^2)
        int res = 0;
        // here we check first number is even or odd
        int count = nums[0] % 2; // count is act as a mutex[OS], like producer-consumer problem
        for(int i = 0; i < nums.length; i++){
            int length = 0;
            for(int j = i; j < nums.length; j++){
                if(count == 1 && (nums[j] % 2) == 1){     // here count = 1 so (num % 2) should be 1
                    length++;
                    count = 0;
                }
                if(count == 0 && (nums[j] % 2) == 0){
                    length++;
                    count = 1;
                }
            }
            res = Math.max(res,length);
        }
        return res;
    }

    public static int maxEvenOddSubArray(int[] nums){   // time : O(n)
        int res = 0, length = 0;
        // here we check first number is even or odd
        int count = nums[0] % 2;    // count is act as a mutex[OS], like producer-consumer problem
        for(int i = 0; i < nums.length; i++){
            if(count == 1 && (nums[i] % 2) == 1){// here count = 1 so (num % 2) should be 1
                length++;
                res = Math.max(res, length);
                count = 0;
            }
            if(count == 0 && (nums[i] % 2) == 0){
                length++;
                res = Math.max(res, length);
                count = 1;
            }
            else{
                length = 1;
            }
        }
        return res;
    }
     */
    public static int maxEvenOddSubArray(int[] nums){   // time : O(n)  // similar to previous approach
        int res = 0, length = 0;
        // here we check first number is even or odd
        int count = nums[0] % 2;    // count is act as a mutex[OS], like producer-consumer problem

        for(int i = 0; i < nums.length; i++){
            if((count == 1 && (nums[i] % 2) == 1) || (count == 0 && (nums[i] % 2) == 0)){// here count = 1 so (num % 2) should be 1
                length++;
                res = Math.max(res, length);
                // update the count for next iteration
                count = (count == 0) ? 1 : 0;   // update if count = 0 then sets count to 1
            }
            else{
                length = 1;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr={10,12,14,7,8};// (14,7,8) = 3
//        int[] arr={5,10,12,6,3,8};// (6,3,8) = 3
//        int[] arr={7,10,13,14};// (7,10,13,14) = 4
//        int[] arr={10,12,8,4};// (10) = 1
        System.out.println(maxEvenOddSubArray(arr));
    }
}
