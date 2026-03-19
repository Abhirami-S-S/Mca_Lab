class Account {
    private int balance = 1000; // initial balance

    // Deposit method
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " | Balance: " + balance);
    }

    // Withdraw method
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew  " + amount + " | Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " tried to withdraw " + amount + " | Insufficient balance!");
        }
    }

    public int getBalance() {
        return balance;
    }
}
class Deposit implements Runnable{
    public Account account;
    public Deposit(Account account){
        this.account=account;
    }

    public void run(){
        for(int i=1;i<=5;i++){
            account.deposit(2000);
            //System.out.println("Balance:"+account.getBalance());
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Withdraw implements Runnable{
    public Account account;
    public Withdraw(Account account){
        this.account=account;
    }

    public void run(){
        for(int i=1;i<=5;i++){
            account.withdraw(1000);
            //System.out.println("Balance:"+account.getBalance());
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class JointAccount{
    public static void main(String[] arg){
        Account account = new Account();

        Thread deposit_ = new Thread(new Deposit(account));
        Thread withdraw_=new Thread(new Withdraw(account));
        deposit_.start();
        withdraw_.start();
        try{
            deposit_.join();
            withdraw_.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());

    }
}
