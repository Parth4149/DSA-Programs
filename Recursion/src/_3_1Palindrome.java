public class _3_1Palindrome {
    /**
     * recurrence T(n) = T(n-2) + theta(1) ,here n-2 : checking corner chars which is reducing length by 2
     * Overall time : O(n)
     */
    public static boolean isPalindrome(String s,int left,int right) {
        if(left >= right) {
            return true;
        }
        return (s.charAt(left) == s.charAt(right)) && isPalindrome(s,left+1,right-1);
    }

    public static boolean isPalindrome(int num, int n, int res) {
        if(n <= 0){
            return (num == res);
        }
        res = (res * 10) + (n % 10);
        return isPalindrome(num, n / 10, res);
    }
    public static boolean isPalindrome(int num){
        return isPalindrome(num, num, 0);
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("abba",0,3));
//        System.out.println(isPalindrome("abbcbba",0,6));
//        System.out.println(isPalindrome("abcbba",0,5));

        System.out.println(isPalindrome(12321));
    }
}

