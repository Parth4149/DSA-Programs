
// Frequencies in a Sorted Array
public class _6_FrequenciesInArray {
    public static void printFreq(int[] arr){ // time : theta(n)
        if(arr.length == 1){
            System.out.println(arr[0]+" "+1);
        }
        int i = 0, freq = 0;
        while(i < arr.length){
            do{
                freq++;
                i++;
            }while(i < arr.length && arr[i - 1] == arr[i]);
            System.out.println(arr[i - 1]+" "+freq);
            freq = 0;// update
        }
    }
    public static void main(String[] args){
        int[] arr = {5,10,10,10,20,20,30};
        printFreq(arr);
    }
}
