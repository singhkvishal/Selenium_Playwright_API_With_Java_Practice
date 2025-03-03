package Java_Examples.Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 1};
        //time complexity =0(n^2)
        //Bubble Sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
            //sort
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }

            Arrays.stream(arr).forEach(System.out::print);
            System.out.println(" ");
        }
    }

}
