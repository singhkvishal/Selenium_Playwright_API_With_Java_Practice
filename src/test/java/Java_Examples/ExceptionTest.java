package Java_Examples;

import org.testng.annotations.Test;

import java.io.IOException;

public class ExceptionTest {
    @Test
    public void TestException(){
        try{
            throw new Exception("Vishal");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        catch (Throwable e){
        System.out.println(e.getMessage());
        }finally {
            System.out.println("Automation test");
        }
    }
}
