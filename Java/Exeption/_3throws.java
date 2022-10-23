package Java.Exeption;

/**
 * throws keyword is required only for checked exception and usage of throws keyword for unchecked exception is meaningless.
 * throws keyword is required only to convince compiler
 * By the help of throws keyword we can provide information to the caller of the method about the exception.
 */
class ThrowsException {
    public static void fun() throws IllegalAccessException {
        System.out.println("Inside fun(). ");
        throw new IllegalAccessException("demo");
    }
    public static void main(String[] args) {
        try {
            fun();
        }
        catch(IllegalAccessException e) {
            System.out.println(e);
            System.out.println("caught in main.");
        }
    }
}
/*
    Inside fun().
    java.lang.IllegalAccessException: demo
    caught in main.
*/
