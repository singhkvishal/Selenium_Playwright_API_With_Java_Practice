package Java_Examples.Thread;

public class MultiThreadExpRun {
    public static void main(String[] args) {

        for(int i=0;i<5;i++) {
            MultiThreadExp multiThreadExp = new MultiThreadExp(i);

            multiThreadExp.start();
        }
    }
}
