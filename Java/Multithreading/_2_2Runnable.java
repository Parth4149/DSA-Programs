package Java.Multithreading;

import static Java.Exeption.Program.ThreadColor.*;

class Thread1 implements Runnable {
    @Override
    public void run(){
        for(int i=1; i<=5; i++){
            System.out.println(ANSI_GREEN+"From Thread with i = "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting from Thread A...");
    }
}
class Thread2 implements Runnable {
    @Override
    public void run(){
        for(int j=1; j<=5; j++){
            System.out.println(ANSI_BLUE+"From Thread with j = "+ 2*j);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting from Thread B...");
    }
}
class Thread3 implements Runnable {
    @Override
    public void run(){
        for(int k=1; k<=5; k++){
            System.out.println(ANSI_RED+"From Thread with k = "+ 3*k);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Exiting from Thread C...");
    }
}

class Demonstration {
    public static void main(String[] args) throws InterruptedException {
        Thread a=new Thread(new Thread1());
        Thread b=new Thread(new Thread2());
        Thread c=new Thread(new Thread3());
        a.start();
        b.start();
        c.start();

        a.join();
        System.out.println(a.isAlive());// it returns false because "a" is terminated by using join()
        //here 3 threads run concurrently
        System.out.println("...Multithreading is over");
    }
}
