/**
 * while the function is not finished executing, it will remain in stack memory(main fun is first fun which is come in the stack and
                                                                                                             last out from the stack)
 * when a function finishes execution, it is removed from stack memory and the flow of program is restore to where the fun was called.
 */
public class _1binaryEquivalent {
    public static void fun(int n){// this method returns binary equivalent of number n
        if(n == 0)
            return;
        fun(n / 2);
        System.out.print(n % 2 + " ");
    }

    public static void main(String[] args) {
        fun(7);
        System.out.println();

        fun(8);
    }
}
