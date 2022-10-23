public class _12minDifference {
//    public static int minDifference(int[] arr){  // TC : theta(nLogn)
//        // sort the array
//        Arrays.sort(arr);
//        // initialize min
//        int min = Integer.MAX_VALUE;
//        // traverse the loop
//        for(int i = 1; i < arr.length; i++){
//            min = Math.min(min, arr[i] - arr[i - 1]);
//        }
//        return min;
//    }
    public static int minDifference(int[] arr){
        if(arr.length == 1){    // handling for 1 element
            return Integer.MAX_VALUE;
        }
        if(arr.length == 2){    // handling for 2 element
            return Math.abs(arr[0] - arr[1]);
        }
        // initialize min & secondMin
        int min = arr[0], secondMin = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                secondMin = min;
                min = arr[i];
            }
        }
        return (secondMin - min);
    }

    public static void main(String[] args) {
        int[] arr = {2,7,15,4,10,0};
//        int[] arr = {8,15}; //7
//        int[] arr = {10}; // INF
//        int[] arr = {8,-1,0,3}; //1
        int ans = minDifference(arr);
        System.out.println(ans);
    }
}
