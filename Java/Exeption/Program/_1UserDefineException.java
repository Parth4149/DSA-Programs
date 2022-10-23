package Java.Exeption.Program;
import java.util.Scanner;

/**
 * if we want to create user define Exception then first we need to create class and extends Exception class
 */
class NegativeIntegerException extends Exception {// user define Exception
    public NegativeIntegerException(String s){ //if we call getMessage() function then it returns the String which we have passed to
        super(s);                                                                                              // the constructor
    }
}
class ZeroSizeException extends Exception {// user define Exception
}
class Test {
    int[] arr;
    public Test(int n) {    // constructor
        arr = new int[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Input Array size :");
            Test t = new Test(sc.nextInt());
            if(t.arr.length <= 0){
                throw new ZeroSizeException();// throw new object of ZeroSizeException
            }
            for(int i = 0; i < t.arr.length; i++){
                System.out.print("Input element :");
                t.arr[i] = sc.nextInt();
                if (t.arr[i] < 0) {
                    throw new NegativeIntegerException("Exception occurs");// throw new object of NegativeIntegerException
                }                                                          //pass the String to the constructor we pass getMessage()
            }
        }
        catch (Exception e) {
            System.out.println(e);
//            System.out.println(e.getMessage());
        }
    }
}



