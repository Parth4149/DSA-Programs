package Java.Exeption.Program;

import static Java.Exeption.Program.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED+"Hello from java_.JAVA_Exeption.Program.MyRunnable class");
    }
}
