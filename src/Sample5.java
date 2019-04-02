public class Sample5 {
    public static void main(String[] args)throws InterruptedException {
        Account account = new Account(1000);
         Transaction[] transactions =
                 {
                         new Transaction(account,100),
                         new Transaction(account,500),
                         new Transaction(account,200),
                         new Transaction(account,50),
                         new Transaction(account,150)

                 };
         for (Transaction tr : transactions)
             tr.start();
        for (Transaction tr : transactions)
            tr.join();

        System.out.println("Total left :" + account.getMoney());
    }


}

class Account {
    private int money;

    public Account(int money){
        this.money = money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}

 class Transaction extends Thread {
     private Account account;
     private int withdraw;

     public Transaction(Account account, int withdraw) {
         this.account = account;
         this.withdraw = withdraw;
     }

     @Override
     public void run() {
         try {
             Thread.sleep(System.currentTimeMillis() % 300);
         } catch (InterruptedException e) {
             return;
         }
     }

 }