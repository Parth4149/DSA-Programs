public class _2print {
    // this method takes less time on modern compiler because it is tail recursive // we should prefer tail recursive approach
    public static void printNto1(int n){//print n to 1 numbers
        //start:
        if(n==0)
            return;
        System.out.print(n+" ");
        printNto1(n-1);// it changes ->   n = n-1; and goto start    // and it doesn't call fun(n-1)
    }

//    public static void print1ToN(int n){// print 1 to n numbers
//        if(n==0)
//            return;
//        print1ToN(n-1);
//        System.out.print(n+" ");
//    }
    public static void print1ToN(int n,int k){// print 1 to n numbers // tail recursive adding a parameter
        if(n==0)
            return;
        System.out.print(k+" ");
        print1ToN(n-1,k+1);
    }
    public static void main(String[] args) {
        printNto1(4);
        System.out.println();
        print1ToN(4,1);
    }
}
