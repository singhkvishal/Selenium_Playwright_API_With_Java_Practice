package Java_Examples.stream;

import java.util.Arrays;

public class SumOfEvonNumber {
    public static void main(String[] arg){
        //imperative approach
        int[]array={1,2,3,4,5,6,7,8,9};
        int sum =0;
        for (int j : array) {
            if (j % 2 == 0) {
                sum = sum + j;

            }
        }
        System.out.println(sum);

        //Stream
        int []array2={1,2,3,4,5,6,7,8,9};
        int sum2= Arrays.stream(array2).filter(n->n%2==0).sum();
        System.out.println(sum2);
    }
}
