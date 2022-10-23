public class _9__Power {

//    public static int power(int x, int n){  // TC : O(n)
//        int ans = 1;
//        for(int i = 0; i < n; i++){
//            ans *= x;
//        }
//        return ans;
//    }

//    public static int power(int x, int n){ // TC : theta(logn) and height = logn, SC : theta(logn) for recursion call
//        if(n == 0){
//            return 1;
//        }
//        if(n % 2 == 0){                                   // even
//            return power(x, n / 2) * power(x, n / 2);
//        }
//        else{                                             // odd
//            return power(x, n - 1) * x;
//        }
//    }

    // Efficient solution
    public static int power(int x, int n){  // TC : O(logn)
        int ans = 1;
        // travers all the bits of a number
        while(n > 0){
            // check if the first bit is 1
            if((n & 1) == 1){
                ans = ans * x;      // x is x to the power of (decimal no of bit) e.g. 1,2,4,8,16...
            }
            n = n / 2;     // OR  n = n >> 1;     // right shift
            x = x * x;
        }
        return ans;
    }

//    public static void printBit(int n){ //
//        while(n > 0){
//            System.out.print(n % 2 +" ");
//            n = n / 2;
//        }
//    }
    public static void main(String[] args) {
//        System.out.println(power(2,4));
//        System.out.println(power(3,4));
//        System.out.println(power(3,0));
        System.out.println(power(2,5));
        System.out.println(power(3,4));
//        printBit(10);
    }
}
