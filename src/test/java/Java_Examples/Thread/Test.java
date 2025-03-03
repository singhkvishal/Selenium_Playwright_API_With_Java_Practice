package Java_Examples.Thread;

public class Test {
    private static volatile Test test;

    private Test() {
    }

    public static Test getInstance() {
        if (test == null) {
            synchronized (Test.class) {
                test = new Test();
            }
        }
        return test;
    }

    public void displayMsg() {
        System.out.println("Message");
    }
}
