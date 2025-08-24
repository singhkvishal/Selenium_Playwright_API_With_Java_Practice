package Java_Examples.InterviewPrograms;

import org.testng.annotations.Test;

public class SwapTwoNumber {
    @Test
    public void Using_Arithmetic_Operators() {
        int a = 17;
        int b = 21;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("A=" + a);
        System.out.println("B=" + b);
    }

    @Test
    public void Using_Arithmetic_Operators_Mul_Div() {
        int a = 17;
        int b = 21;

        a = a*b; //now a is 357 and b is 21
        b = a/b; //now a is 357 but b is 17 (original value of a)
        a = a/b; //now a is 21 and b is 17, numbers are swapped

        System.out.println("A=" + a);
        System.out.println("B=" + b);
    }

    @Test
    public void Using_Bitwise_XOR() {
        int a = 17;
        int b = 21;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("A=" + a);
        System.out.println("B=" + b);
    }
}
