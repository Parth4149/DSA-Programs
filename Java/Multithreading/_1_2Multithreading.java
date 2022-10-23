package Java.Multithreading;

import static Java.Exeption.Program.ThreadColor.*;
class ThreadA extends Thread {
    @Override
    public void run(){
        for(int i=1; i<=5; i++){
            System.out.println(ANSI_GREEN+"From Thread with i = "+ -1*i);
        }
        System.out.println("Exiting from Thread A...");
    }
}
class ThreadB extends Thread {
    @Override
    public void run(){
        for(int j=1; j<=5; j++){
            System.out.println(ANSI_GREEN+"From Thread with j = "+ 2*j);
        }
        System.out.println("Exiting from Thread B...");
    }
}
class ThreadC extends Thread {
    @Override
    public void run(){
        for(int k=1; k<=5; k++){
            System.out.println(ANSI_RED+"From Thread with k = "+ ( 2*k - 1));
        }
        System.out.println("Exiting from Thread C...");
    }
}

class Main2{
    public static void main(String[] args) {
        Thread a=new Thread(new Thread1());
        Thread b=new Thread(new Thread2());
        Thread c=new Thread(new Thread3());
        a.start();
        b.start();
        c.start();
        // if we use run() then thread will be run simultaneously not concurrently
        System.out.println("...Multithreading is over");
    }
}
