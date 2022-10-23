public class _10_singleNumber {
    public static int singleNumber(int[] nums){  // TC : O(n)      SC: O(1)
        int ans = 0;
        for(int x : nums){
            ans = ans ^ x;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        System.out.println(singleNumber(arr)); // 5
    }
}
