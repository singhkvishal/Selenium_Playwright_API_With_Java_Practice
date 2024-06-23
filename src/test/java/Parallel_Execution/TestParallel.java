package Parallel_Execution;

import org.testng.annotations.Test;
//Run using the command to execute the .xml file
// "java org.testng.TestNG testng.xml"
public class TestParallel {
    @Test
    public void method1() {
        long id = Thread.currentThread().getId();
        System.out.println("Inside method1()" + " Thread Name =" +id);
        //Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test
    public void method2() {
        long     id = Thread.currentThread().getId();
        System.out.println("Inside method2()" + "Thread Name =" + id);
    }
    @Test
    public void method3() {
        long     id = Thread.currentThread().getId();
        System.out.println("Inside method3()" + "Thread Name =" + id);
    }
}
