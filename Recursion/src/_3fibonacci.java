public class _3fibonacci {
    /**
     * fibo(n) = fibo(n-1) + fibo(n-2) This is known as recurrence relation
     */
    public static int fibo(int n){
        if(n <= 1)
            return n;
        else
            return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibo(5));//5
        System.out.println(fibo(6));//8
    }
}
