package ParallelTest_Examples.TestNG_Example;

import org.testng.annotations.Test;

public class TestNG_ParallelTest {
    @Test(threadPoolSize = 3,invocationCount = 6,invocationTimeOut = 500000)
    void testMethod1() throws InterruptedException {
        System.out.println("Test Method First Start =>"+ Thread.currentThread().getId());
        Thread.sleep(5000);
        System.out.println("Test Method First End =>"+ Thread.currentThread().getId());
    }

    @Test
    void testMethod2() throws InterruptedException {
        System.out.println("Test Method Second Start =>"+ Thread.currentThread().getId());
        Thread.sleep(5000);
        System.out.println("Test Method Second End =>"+ Thread.currentThread().getId());
    }
}
