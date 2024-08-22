package Java_Examples;

import org.junit.jupiter.api.Test;

public class PrePostIncrement {
    @Test
    public void SimpleTest(){
        int a=10;
        System.out.println(a++ + ++a);
    }
    @Test
    public void ComplexTest(){
        int a=11,b=22,c;
        c=a + b + a++ + b++ + ++a + ++b;
        System.out.println("A="+a);
        System.out.println("B="+b);
        System.out.println("C="+c);

    }
}
