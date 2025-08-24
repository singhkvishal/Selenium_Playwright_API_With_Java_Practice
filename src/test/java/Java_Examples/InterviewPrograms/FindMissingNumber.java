package Java_Examples.InterviewPrograms;

import org.testng.annotations.Test;

public class FindMissingNumber {
    @Test
    public void Test() {
        int[] num = {1, 2, 3, 4, 5, 6, 8};
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i <= 8; i++) {
            sum = sum + i;
        }

        for (int i = 0; i < num.length; i++) {
            sum1 = sum1 + num[i];
        }

        System.out.println("Missing mumber =" + (sum - sum1));
    }
}