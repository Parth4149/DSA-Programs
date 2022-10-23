public class _2LeftShift {
    public static void main(String[] args) {
        int x=3;
        System.out.println(x<<1);// 00...011 -> 00...00110
        System.out.println(x<<2);// 00...011 -> 00...01100
        System.out.println(x<<3);// 00...011 -> 00...11000
        System.out.println(x<<-1);// OR (x<<31) both are equal
    }
}
