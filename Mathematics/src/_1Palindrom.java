public class _1Palindrom {
    public static boolean isPalindrom(int num){
        int n = num;
        int rev = 0;
        while(n > 0){
            int r = n % 10;
            rev = rev * 10 + r;
            n = n / 10;
        }
        return (num == rev);
    }
    public static void main(String[] args) {
        System.out.println(isPalindrom(121));
        System.out.println(isPalindrom(123));
    }
}
