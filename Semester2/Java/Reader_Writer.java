class Reader implements Runnable{
    static final Object lock = Reader_Writer.Lock;
    public void run(){
        synchronized (lock) {
        try {
            lock.wait();
            System.out.println("Read A");
            Thread.sleep(500);
            System.out.println("Read B");
            Thread.sleep(500);
            System.out.println("Read C");
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
     }
    }
}
class Writer implements Runnable{
    static final Object lock=Reader_Writer.Lock;
    public void run(){
        synchronized (lock) {
        try {
            System.out.println("Write A");
            Thread.sleep(500);
            System.out.println("Write B");
            Thread.sleep(500);
            System.out.println("Write C");
            lock.notify();
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    }
}
public class Reader_Writer {
    static final Object Lock=new Object();
    public static void main(String[] arg){
        Reader re =new Reader();
        Writer wr=new Writer();
        Thread read = new Thread(re);
        Thread write = new Thread(wr);
        read.start();
        write.start();
    }
}
