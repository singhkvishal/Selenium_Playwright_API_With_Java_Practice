package Java_Examples.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 1};
        //time complexity =0(n^2)
        //Selection  Sort
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;

            for (int j = i + 1; j < arr.length; j++) {
                //sort
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;

            Arrays.stream(arr).forEach(System.out::print);
            System.out.println(" ");
        }
    }
}
