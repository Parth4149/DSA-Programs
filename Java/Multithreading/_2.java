package Java.Multithreading;

class MultiThreading extends Thread{
    private int ThreadNumber;
    public MultiThreading(int ThreadNumber){
        this.ThreadNumber=ThreadNumber;
    }
    @Override
    public void run() {
        for(int i=1; i<=3; i++){
            System.out.println(i+" from Thread : "+ThreadNumber);
            if(ThreadNumber==3){
                throw new RuntimeException();//if thread 3 throw an exception then other thread can run continue
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Main4{
    public static void main(String[] args) {
        for(int i=1; i<=3; i++){
            MultiThreading myThing = new MultiThreading(i);
            myThing.start();
        }
    }
}
