import java.util.Arrays;

public class _8__TrappingRainWater {
    public static int trappingRainWater(int[] height) {// time : theta(n) , space : theta(n)
        int res = 0, n = height.length;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        // assign height[0] as 1st ele of array leftMax
        leftMax[0] = height[0];
        // traverse the array height using index i from 1 to n - 1 (2nd ele to last ele)
        for (int i = 1; i < n; i++) { // forward (left to right)
            // here we compare curr height and last max height
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // assign height[n-1] as last ele of arr rightMax
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) { // backward (right to left)
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            res += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
        return res;
    }

    /**
     * // 5, 0, 6, 2, 3  arr
     * <p>
     * // 5, 5, 6, 6, 6  leftMax first loop
     * // 6, 6, 6, 3, 3  rightMax  second loop
     * <p>
     * // 5, 5, 6, 3, 3  min of left and right
     * //    5, 0, 1     = 6  diff between min and arr
     */
    public static void main(String[] args) {
//        int[] arr={5,0,6,2,3};
        int[] arr = {4, 2, 0, 3, 2, 5};
//        int[] arr={3,0,1,2,5};
//        int[] arr={1,2,3,4,5};
//        int[] arr={5,4,3,2,1};
        System.out.println(trappingRainWater(arr));//6
    }
}
