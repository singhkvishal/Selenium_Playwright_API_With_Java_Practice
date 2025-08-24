package Java_Examples.InterviewPrograms;

import org.testng.annotations.Test;

public class ReverseInteger {
    @Test
    public void ReverseInt(){
        int val=12345;

        String outPut="";
        while(val>0){
            outPut=outPut+val%10;
            val =   val/10;
        }
        System.out.println(outPut);
    }
}
