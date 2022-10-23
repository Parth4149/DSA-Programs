// print all the prime numbers

public class _6_SieveOfEratosthenes {
    /**
     * by default all the element are false
     * loop starting from 2 because first prime number is 2
     * we make all the multiple of i  true
     * if we use i instead of i*i then multiple of i come again and make true again
     * e.g. i=2 multiple of i are 2,4,8... coma again and make it true again
     * if we start from i*i, we can prevent it
     */
    public static void printPrimes(int n){      // time : O(n log(logn)) , space : O(n)
        // by default all the element are false
        boolean[] prime = new boolean[n+1];
        // loop starting from 2 because first prime number is 2
        for(int i = 2; i <= n; i++){
            if(!prime[i]){
                System.out.print(i+" ");
                    // we make all the multiple of i  true
                    // if we use i instead of i*i then multiple of i come again and make true again
                    // after completing each pass j is increment by i
                for(int j = i*i; j <= n; j += i){   // e.g. i=3 multiple of i are 3,6,9... come again and make it true again
                    prime[j] = true;                        // if we start from i*i, we can prevent it
                }
            }
        }
    }

/**  // Naive approach
    public static void printPrimes(int n){   // time : O(n * sqrt(n))   space : O(1)
        for(int i = 2; i <= n; i++){
            if(ifPrime(i)){
                System.out.print(i+" ");
            }
        }
    }
    private static boolean ifPrime(int n){
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
*/
    public static void main(String[] args) {
        printPrimes(50);
    }
}
//2 3 5 7 11 13 17 19 23 29 31 37 41 43 47
