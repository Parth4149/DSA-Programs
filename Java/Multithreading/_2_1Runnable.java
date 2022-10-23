package Java.Multithreading;

// Java code for thread creation by implementing the Runnable java_.OOPs.Interface
class MultithreadingDemo2 implements Runnable {
    @Override
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}

// java_.JAVA_Exeption.Program.java_.Java_Multithreading.Main Class
class Multithread2 {
    public static void main(String[] args) {
        int n = 8; // Number of threads
        for (int i = 0; i < n; i++) {
            Thread obj = new Thread(new MultithreadingDemo2());
            obj.start();
        }
    }
}
