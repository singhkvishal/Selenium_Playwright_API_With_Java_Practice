package Java_Examples.InterviewPrograms;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestSmallestNumber {
    @Test
    public void LargestSmallest() {
        int[] num = {3, 7, 4, 9, 1};
        int a[] = Arrays.stream(num).sorted().toArray();
        System.out.println("Smalest number =>" + a[0]);
        System.out.println("Largest number =>" + a[a.length - 1]);

        Arrays.stream(num).distinct().sorted().forEach(System.out::println); // Reverse Order

    }
    @Test
    public void LargestSmallest1() {
        int[] num = {3, 7, 4, 9, 1};
        int largest = num[0];
        int smallest = num[0];

        for (int i = 1; i < num.length; i++) {
            if (num[i] > largest) {
                largest = num[i];
            } else if (num[i] < smallest) {
                smallest = num[i];
            }
        }
        System.out.println("Largest number "+largest);
        System.out.println("Smallest number "+smallest);
    }
    @Test
    public void LargestSmallest2() {
        int[] num = {3, 7, 4, 9, 1,2};
        int len =num.length;
        for(int i=0;i<len;i++){
            for (int j =0;j<len-i-1;j++){
                if(num[j]>num[j+1]){
                    int temp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp;
                }
            }
        }
        System.out.println("Largest number "+num[len-1]);
        System.out.println("Smallest number "+num[0]);
    }

}
