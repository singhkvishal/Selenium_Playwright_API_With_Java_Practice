package Java_Examples.SingletonPattern;

public class TestBrowser {
    public static void main(String[] args) {
        //BrowserExample.getInstance().DisplayMessage();
        
        Runnable task = () -> {
            BrowserExample.getInstance().DisplayMessage();
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        Thread thread4 = new Thread(task);
        Thread thread5 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        //wait for all thread to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
