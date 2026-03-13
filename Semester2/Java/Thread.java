class ThreadA extends Thread{
    public void run(){
        System.out.println("Thread A is running ...");
        for(int i=1;i<=10;i++){
            System.out.println("Square of "+i+" :" + (i*i));
            try{
                ThreadA.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class ThreadB implements Runnable{
    public void run(){
        System.out.println("Thread B is running ...");
        for(int i=1;i<=10;i++){
            System.out.println("Cube of "+i+"   :" + (i*i*i));
            try{
                Thread.sleep(700);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class Pg23 {
    public static void main(String[] args){
        ThreadA tA = new ThreadA();
        ThreadB runnable = new ThreadB();
        Thread tB=new Thread(runnable);
        tA.start();
        tB.start();
        try{
            tA.join();
            tB.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Calculation Completed !");
    }
}
