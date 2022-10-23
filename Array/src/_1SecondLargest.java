public class _1SecondLargest {
    public static int SecondLargest(int[] arr){
        int largest = 0, secondLargest = 0;
        for(int i = 1; i < arr.length; i++){   // time : theta(n)
            if(arr[i] > arr[largest]){
                secondLargest = largest;
                largest = i;
            }
        }
        if((arr.length == 1 ) || (largest == secondLargest)){
            return -1;
        }
        System.out.println("second largest :"+secondLargest+"\t"+"largest : "+largest);
        return secondLargest;
    }
    public static void main(String[] args) {
        int[] arr = {10,33,10,45,45,15};
        System.out.println(SecondLargest(arr));
    }
}
