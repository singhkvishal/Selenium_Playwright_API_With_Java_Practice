package Java_Examples.AutoDesignPattern.SingletonPattern;

public class BrowserExample {
    //1. Private static instance of the class
    private static volatile BrowserExample browserExample;//null;

    //2. Private constructor to prevent / avoid instance /object
    private BrowserExample() {
    }

    //3. Public static getInsatnce method to provide access to the instance/object
    /*volatile vs synchronized: Before we move on let’s take a look at two important features of locks and synchronization.
       Mutual Exclusion: It means that only one thread or process can execute a block of code (critical section) at a time.
       Visibility:  It guarantees that value of the volatile variable will always be read from the main memory, not from the local thread cache.
                    It means that changes made by one thread to shared data are visible to other threads.
    */
    public static BrowserExample getInstance() {
        if (browserExample == null) {
            synchronized (BrowserExample.class) {
                if (browserExample == null) {
                    browserExample = new BrowserExample();
                }
            }
        }
        return browserExample;
    }

    public void DisplayMessage(String threadId) {
        System.out.println("Browser Info : " + threadId);
    }
}
