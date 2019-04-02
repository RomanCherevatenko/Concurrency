class TestThread2 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hi I am "+this.getClass().getName());
    }
}




public class Sample2 {
    public static void main(String[] args) throws InterruptedException {
        TestThread2 testThread2 = new TestThread2();
        testThread2.start();
        testThread2.join();
        System.out.println("Finish");
    }
}
