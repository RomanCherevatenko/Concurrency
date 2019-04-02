public class Sample6 {
    public static void main(String[] args)throws InterruptedException {
        Account account = new Account(1000);
        Transaction [] transaction ={
                new Transaction(account,100),
                new Transaction(account,500),
                new Transaction(account,200),
                new Transaction(account,50),
                new Transaction(account,150),


        };
        for (Transaction tr : transaction)
            tr.start();
        for (Transaction tr : transaction)
            tr.join();

        System.out.println("Totsl left:" + account.getMoney());

    }

   static class Account{
        private int money;

        public Account  (int money) {
            this.money = money;
        }

        public int getMoney() {
            return money;
        }

        public synchronized void withdraw(int amount) {
            if (money >= amount) {
                money -= amount;
            }
        }
    }

  static class Transaction extends Thread {
        private Account account;
        private int amount;

        public Transaction(Account account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(System.currentTimeMillis() % 300);
            } catch (InterruptedException e) {
                return;
            }
            account.withdraw(amount);
        }
    }
}