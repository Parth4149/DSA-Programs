public class _5Prime {
    /**
        here we use Math.sqrt(n) because factors of 30 : (1,30),(2,15),(3,10),(5,6)      65 : (1,5),(5,13)   25 : (1,25),(5,5)
        here all factors are less than or equal to root(n)
     */
    public static boolean isPrime(int n){   // time O(sqrt(n))
        if(n == 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPrime(7));
        System.out.println(isPrime(2));
        System.out.println(isPrime(25));
        System.out.println(isPrime(30));
    }
}
