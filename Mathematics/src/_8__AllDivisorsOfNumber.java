public class _8__AllDivisorsOfNumber {
    // in this solution all the divisors print ascending order
    // time : theta(sqrt(n)) + theta(sqrt(n)) = theta(2sqrt(n)) = theta(sqrt(n)) , auxiliary space : theta(1)
    public static void printDivisors(int n){
        int i = 1;
        // (i * i) < n) is similar to i < sqrt(n)
        while((i * i) < n){       // print all divisors from 1 to root(n)
            if(n % i == 0){
                System.out.print(i+" ");
            }
            i++;        // if(i*i<=n) then i will be root(n)+1 and root(n) occurs(or print) twice,so consider if(i*i<n)
        }
        while(i >= 1){        // print all divisors from root(n) to n
            if(n % i == 0){
                System.out.print((n / i)+" ");
            }
            i--;
        }
    }
/**
  //in this solution all the divisors print pairwise

    public static void printDivisors(int n){    // time : theta(sqrt(n))
        for(int i = 1; i*i <= n; i++){  // (i * i) < n) is similar to i <= sqrt(n)
            if(n % i == 0){
                System.out.print(i+" ");
                if(i! = (n / i)){   // don't print number again
                    System.out.print((n / i)+" ");    // print all the divisors pairwise
                }
            }
        }
    }
*/
    public static void main(String[] args) {
//        printDivisors(25);
        printDivisors(12);
    }
}
