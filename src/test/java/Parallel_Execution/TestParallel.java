package Parallel_Execution;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//Run using the command to execute the .xml file
// "java org.testng.TestNG testng.xml"
public class TestParallel {
    @BeforeSuite
    public void Setup(){
        String tID=Thread.currentThread().getThreadGroup().getName();
        System.out.println("Start Execution");
    }
    @Test
    public void method1() {
        String tID = Thread.currentThread().getName();
        System.out.println("Inside method1()" + " Thread Name =" + tID);
        //Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test
    public void method2() {
        String tID=Thread.currentThread().getThreadGroup().getName();
        System.out.println("Inside method2()" + "Thread Name =" + tID);
    }

    @Test
    public void method3() {
        String tID=Thread.currentThread().getThreadGroup().getName();
        System.out.println("Inside method3()" + "Thread Name =" + tID);
    }

    @AfterSuite
    public void TearDown(){
        System.out.println("Stop Execution");
    }
}
