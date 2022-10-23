public class _3RightShift{
    public static void main(String[] args) {
        int x=14;
        System.out.println(x>>1);// 00...1110 -> 00...0111
        System.out.println(x>>3);// 00...1110 -> 00...0001
        System.out.println(x>>-1);// 00...1110 -> 00...0000

        System.out.println();
        // here first two bits(10) are removed and add two bits(11) at the end  // starting from left
        System.out.println(-2>>1);// 111...110 -> 111...111 => x^32 - 1 = -1  it represents -1
        System.out.println(-2>>2);// 111...110 -> 111...111 => x^32 - 1 = -1  it represents -1
        // it -2 with any value which >=1 , answer will be -1

        System.out.println();



        System.out.println(x>>>1);//unsigned right shift // negative values become(make) positive
        //00...1110 -> 00...0111

        System.out.println(-2>>>1);// x = 111...110 , (-2>>1) -> 011...111  // 2^31 - 1   // e.g (2^3 - 1 = 111)

    }
}