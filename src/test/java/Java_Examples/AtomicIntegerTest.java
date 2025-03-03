package Java_Examples;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static void main(String[] args) {
        int n = 1000000000;
        int i = 0;
        long start = System.currentTimeMillis();
        while (i < n) {
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println("int: " + (end - start) + "ms");

        Integer in = 0;
        start = System.currentTimeMillis();
        while (in < n) {
            in++;
        }
        end = System.currentTimeMillis();
        System.out.println("Integer: " + (end - start) + "ms");

        AtomicInteger ai = new AtomicInteger(0);
        start = System.currentTimeMillis();
        while (ai.get() < n) {
            ai.incrementAndGet();
        }
        end = System.currentTimeMillis();
        System.out.println("AtomicInteger: " + (end - start) + "ms");
    }
}
