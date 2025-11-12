package ParallelTest_Examples.Java_Threads;

// Main Class
public class Java_Runnable_Example {
    public static void main(String[] args) {
        int n = 8; // Number of threads
        for (int i = 0; i < n; i++) {
            Thread object = new Thread(new Runable_Test());
            object.start();
        }
    }
}

class Runable_Test implements Runnable{
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {

            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}