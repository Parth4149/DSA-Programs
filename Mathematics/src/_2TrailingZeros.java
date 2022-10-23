import java.math.BigInteger;

public class _2TrailingZeros{
//    public static int fact(int n){ time : theta(n) , auxiliary space : theta(n)
//        if(n == 0 || n == 1){
//            return 1;
//        }
//        else{
//            return n * fact(n-1);
//        }
//    }
    public static BigInteger fact(int n){   //  time : theta(n) , auxiliary space : O(1)
        BigInteger res = new BigInteger(String.valueOf(1));
        for(int i = 2; i <= n; i++){
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    public static int TrailingZeros(int n){      // time : theta(logn)  // 5^k <= n  , k*log5 = logn , k = logn (base 5)
        if(n < 25){
            return n / 5;
        }
        int res = 0;
        // i = 5,25,125,625,...
        for(int i = 5; i <= n; i = i * 5){      // this is for n >= 25
            res += n / i;
        }
//        int div = 5;
//        while(div <= n){
//            res += n / div;
//            div = div * 5;
//        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(TrailingZeros(5));// 1
        System.out.println(TrailingZeros(10));// 2
        System.out.println(TrailingZeros(15));// 3
        System.out.println(TrailingZeros(20));// 4
        System.out.println(TrailingZeros(25));// 6     i=5, i=25, i=125
        System.out.println(TrailingZeros(100));// 24   i=5, i=25, i=125
    }
}
