public class _5CountSetBits {
    public static int CountSetBits(int n){   //
        int count = 0;
        while(n > 0){
            if((n & 1) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(CountSetBits(1));
        System.out.println(CountSetBits(5));
        System.out.println(CountSetBits(7));
        System.out.println(CountSetBits(13));
    }
}
