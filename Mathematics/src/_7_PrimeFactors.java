public class _7_PrimeFactors {

//    public static void PrimeFactors(int n){ // TC : theta(sqrt(n))
//        int i = 2;
//        while(n > 1 || i <= Math.sqrt(n)){
//            if(n % i == 0){
//                System.out.print(i+" ");
//                n = n / i;
//            } else{
//                i++;
//            }
//        }
//    }
    public static void PrimeFactors(int n){  // TC : theta(sqrt(n))
        // after each pass we divide n by 2
        while(n % 2 == 0){ // we can say 2 divides n (n is divide by 2)
            System.out.print(2+" ");
            n = n / 2;
        }
        while(n % 3 == 0){
            System.out.print(3+" ");
            n = n / 3;
        }
        // 2 3 5 7 11 13 17 19...
        // in single iteration covers 1 pair   (5,7), (11,13), (17,19),...
        // after the first pass i incremented by 6
        // here the condition is (i * i) <= n , simple concept of find prime number (in this we travers loop from 2 to sqrt(n) times)
        for(int i = 5; (i * i) <= n; i = i + 6){
            while(n % i == 0){
                System.out.print(i+" ");
                n = n / i;
            }
            while(n % (i + 2) == 0){
                System.out.print((i + 2)+" ");
                n = n / (i + 2);
            }
        }
        if(n > 3){        // e.g. if(n==prime && n>3) then this statement will execute
            System.out.print(n);    // e.g. 13,17,23  it works for all prime no. between 9 and 25
        }
    }

    public static void main(String[] args) {
        PrimeFactors(12);// multiplication of all prime factors(2,2,3) = 12
//        PrimeFactors(23);//
//        PrimeFactors(33);//
//        PrimeFactors(315);
    }

}
