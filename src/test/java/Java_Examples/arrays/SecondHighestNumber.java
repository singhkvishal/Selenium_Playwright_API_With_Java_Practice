package Java_Examples.arrays;

import org.testng.annotations.Test;

public class SecondHighestNumber {
    @Test
    public void SecondLargestNumber() {
        int[] arrayValues = {12, 4, 3, 7, 8, 23, 90, 100};

        for (int i = 0; i <= arrayValues.length - 1; i++) {
            int ele = arrayValues[i];

            if (i == arrayValues.length - 1) break;

            else if (ele > arrayValues[i + 1]) {
                arrayValues[i] = arrayValues[i + 1];
            }
        }
        System.out.println(arrayValues[arrayValues.length - 2]);
    }

    @Test
    public void SecondLargestNumber2() {
        int[] arr = {12, 4, 3, 7, 8, 23, 90, 100, 12};
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        System.out.println(secondLargest);
    }


    @Test
    public void secondLargestNumberUsingShorting() {
        int[] arr = new int[]{6, 8, 7, 4, 312, 78, 54, 9, 12, 100, 89, 74};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i +1; j < arr.length; j++) {
                int tmp = 0;
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        System.out.println(arr[arr.length - 2]);
    }
}


