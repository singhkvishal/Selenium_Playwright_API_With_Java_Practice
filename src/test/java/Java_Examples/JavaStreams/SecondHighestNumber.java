package Java_Examples.JavaStreams;

import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class SecondHighestNumber {
    @Test
    public void GetSecondHighest() {
        int numbers[] = {14, 57, 2, 89, 6, 34};

        Integer SecondHighestNumber = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println(SecondHighestNumber);
    }

    @Test
    public void GetArrayofNumberBetwwentwoRange(){
        System.out.println(Arrays.toString(BetweenRange(1,6)));
    }

  public static int[] BetweenRange(int a,int b){
        return IntStream.rangeClosed(a,b).toArray();
  }


}
