package Java.Exeption.Program;

import static Java.Exeption.Program.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread{
    public void run(){
        System.out.println("Hello from "+currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            System.out.println(ANSI_BLUE+"Another thread woke me up");
        }
        System.out.println(ANSI_BLUE+"Two seconds have passed and I'm awake");
    }
}
