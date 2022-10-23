package Java.OOPs.Polymorphism;
/**

  Method overloading (Compile-time polymorphism OR Static polymorphism):

 -------------------------------------------------------
 What is Compile time and Runtime:
 * Compile time is the period when the programming code(source code) is converted into the machine code
 * Runtime is the period of time when a program is running and generally occurs after compile time
 */
class Helper {
    static int Multiply(int a, int b) {
        return a * b;
    }
    static double Multiply(double b) {
        return 5.5 * b;
    }
    static int Multiply(int a, int b, int c) {
        return a * b * c;
    }
}
class test {
    public static void main(String[] args) {
        // Calling method by passing input as in arguments
        System.out.println(Helper.Multiply(3, 4));
        System.out.println(Helper.Multiply(6.3));
        System.out.println(Helper.Multiply(2,3,4));
    }
}
