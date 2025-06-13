package Java_Examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list =Arrays.asList(1,2,3);
        Integer sum= list.stream().reduce(5,(a,b)->a+b);
        System.out.println(sum);

        Integer psum= list.parallelStream().reduce(5,(a,b)->a+b);
        System.out.println(sum.equals(psum));
        int a=10;
        int b=20;
    }
}
