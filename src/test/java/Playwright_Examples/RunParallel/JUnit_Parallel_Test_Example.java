package Playwright_Examples.RunParallel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class JUnit_Parallel_Test_Example {
    @Test
    void test1() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Test1 " + Thread.currentThread().getName());
    }

    @Test
    void test2() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Test2 " + Thread.currentThread().getName());
    }
}
