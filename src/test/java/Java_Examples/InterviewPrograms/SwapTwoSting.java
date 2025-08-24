package Java_Examples.InterviewPrograms;

import org.testng.annotations.Test;

public class SwapTwoSting {
    @Test
    public void Swaptring(){
        String a="Vishal";
        String b="Singh";

        a=a+b;//VishalSingh
        b=a.substring(0,a.length()-b.length());
        System.out.println("B="+b);

        a=a.substring(b.length());
        System.out.println("A="+a);
    }
}
