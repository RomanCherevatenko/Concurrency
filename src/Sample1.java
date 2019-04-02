class  Test1 extends Thread{
    @Override
    public void run() {
        System.out.println("hi I am "+this.getClass().getName());

    }
}
class  Test2 implements Runnable{

    public void run() {
        System.out.println("hi I am "+this.getClass().getName());

    }
}


public class Sample1 {
    public static void main(String[] args) {


        Test1 thread1 = new Test1();
        thread1.setDaemon(true);
        thread1.start();
  //      thread1 .setPriority(Thread.MAX_PRIORITY);



        Thread thread2 = new Thread(new Test2());
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hi I am "+this.getClass().getName());

            }
        });
        thread3.start();
        System.out.println("Finish  ");
    }
}
