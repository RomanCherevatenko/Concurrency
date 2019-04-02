class TestThreed4 extends Thread {
    private volatile boolean stop;

    @Override
    public void run() {

        while (!stop) {
            System.out.println("Prog");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }

    }

    public void myInterrupt() {
        stop = true;
    }
}
public class Sample4 {
    public static void main(String[] args)throws InterruptedException {
        Thread thread = new Thread(new TestThreed3());
        thread.start();

        Thread.sleep(5000);
        thread.interrupt();
    }
}