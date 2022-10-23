package Java.Multithreading;

/**
 * Multithreading is a process of executing multiple threads concurrently
 * Threads use a shared memory area because they don't allocate separate memory area, so it saves memory and
   Context switching between the threads takes less memory than process

 Advantages of Java Multithreading:
 1) It doesn't block the user because threads are independent
 2) we can perform many operations together, so it saves time.
 3) Threads are independent, so it doesn't affect other threads if an exception occurs in a single thread.

 Java Thread Methods:
 start() : It is used to start the execution of the thread.
 run() : It is used to do an action for a thread.
 sleep() : It sleeps a thread for the specified amount of time.
 */
class Test extends Thread {
    @Override
    public void run() {
        System.out.println("I am from Run...");
        System.out.println(Thread.currentThread().getName());
    }
}
class Main{
    public static void main(String[] args) {
        Test t = new Test();
        t.start();
//        t.run();
        // the result is 2 threads are running concurrently
        // the current thread (which call to the start method) and the other thread (which executes run method)
    }
}

