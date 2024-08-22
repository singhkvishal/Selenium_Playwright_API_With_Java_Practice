package Java_Examples;

import java.sql.SQLOutput;

public class IntegestRange_Example {
    public static void main(String[] args) {
        //Integer caching/pool : range : -128 to 127
        Integer t1=100;
        Integer t2=100;
        System.out.println(t1==t2);

        System.out.println("Minimum value of Integer is: " + Integer.MIN_VALUE);
        System.out.println("Maximum value of Integer is: " + Integer.MAX_VALUE);

        Integer p1=200;
        Integer p2=200;
        System.out.println(p1==p2);

    }
}
