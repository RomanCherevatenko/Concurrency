class TestThreed3 implements Runnable{
    @Override
    public void run() {
        while ( !Thread.currentThread().isInterrupted()){
            System.out.println("Prog");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }

    }
}

public class Sample3 {
    public static void main(String[] args)throws InterruptedException {
        Thread thread = new Thread(new TestThreed3());
        thread.start();

        Thread.sleep(5000);
        thread.interrupt();
    }
}
