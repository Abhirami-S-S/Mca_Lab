class CPU{
    int price;
    CPU(int p){
        price=p;
    }
    void display(){
        Processor p1=new Processor(16,"intel");
        p1.display();
        RAM.display();
        System.out.println("CPU Price:" + price);
    }
    class Processor{
        int no_of_cores;
        String mfr;
        Processor(int n,String m){
            no_of_cores=n;
            mfr=m;
        }
        void display(){
            System.out.println("Processor Cores :" + no_of_cores);
            System.out.println("Processor Manufacturer:" + mfr);
        }
    }
    static class RAM{
        static int memory=32;
        static String mfr="Kingston";
        static void display(){
            System.out.println("RAM Memory :" + memory);
            System.out.println("RAM Manufacturer :" + mfr);
        }
    }
}
public class CpuDemo {
    public static void main(String[] arg){
        CPU cpu1 = new CPU(12000);
        cpu1.display();
    }
}
