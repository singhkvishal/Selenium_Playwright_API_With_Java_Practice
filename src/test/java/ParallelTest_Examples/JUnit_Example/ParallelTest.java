package ParallelTest_Examples.JUnit_Example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
//Please refer this file for execution mode
//..\src\main\resources\junit-platform.properties
@Execution(ExecutionMode.CONCURRENT)
public class ParallelTest {
    @Test
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
