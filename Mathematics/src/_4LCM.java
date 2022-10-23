public class _4LCM {
    public static int GCD(int a,int b){
        if(b == 0)
            return a;
        else
            return GCD(b,a % b);
    }
    /**
         a * b = GCD(a,b) * LCM(a,b)
     */
    public static int LCM(int a,int b){
            return (a * b) / GCD(a, b);
    }
    public static void main(String[] args) {
        System.out.println(LCM(3,7));//21
        System.out.println(LCM(4,6));//12
        System.out.println(LCM(12,15));//60
    }
}
