package Java.Exeption;

/**
 * Error mostly occur at runtime
 * Exception can occur at compile time and runtime.
 * Error is Irrecoverable, whereas Exception is Recoverable.

 * Java exception handling is managed via five keywords: try, catch, finally, throw and throws
 * If an exception occurs within the try block, it is thrown. Your code can catch this exception (using catch block) and handle it
 * finally block must be executed after a try block completes

------------------------------------------------------------------------------------
 exception : An error that occurs in a program during runtime
 exception is an event that disrupts the normal flow of the program. It is an object which is thrown at runtime.

 * try : it is used to specify a block where there is an Exception placed
 * catch : it is used to handle the exception.
 * finally : it is used to execute the necessary code of the program. it is executed whether an exception is handled or nor
 * throw : it is used to throw an exception.
 * throws : it is used to declare exceptions.

 Advantages:
 * maintain the normal flow of the application
 ------------------------------------------------------------------------------------

How to use try-catch clause?
    try {
        // block of code to monitor for errors
        // the code you think can raise an exception
    }
    catch (ExceptionType1 e) {
        // exception handler for ExceptionType1
    }
    catch (ExceptionType2 e) {
        // exception handler for ExceptionType2
    }
    finally {
        // block of code to be executed after try block ends
    }
 **/

public class _1Basics {
    public static void main(String[] args){
        try{
            int a = 10;
            int b = 0;
            int c = a / b;//code that may raise exception
        }
        catch(ArithmeticException e){
            System.out.println(e);
            System.out.println(e.getMessage());
        }
        System.out.println("rest of the code...");
    }
}
/*
    java.lang.ArithmeticException: / by zero
    / by zero
    rest of the code...
*/
