public class _1 {
    public static void main(String[] args) {// java represents 32 bit
        int a=3,b=6;
        System.out.println(a&b);//bitwise AND
        System.out.println(a|b);//bitwise OR
        System.out.println(a^b);//bitwise X-OR

        //bitwise NOT
        System.out.println(~4);// 2^32 - 1 - 4 = 2^32 - 5
        System.out.println(~5);// 2^32 - 1 - 5 = 2^32 - 6
        // 2^3-1=111, 2^5-1=11111
    }
}
