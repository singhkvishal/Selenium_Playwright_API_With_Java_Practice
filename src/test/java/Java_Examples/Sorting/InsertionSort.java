package Java_Examples.Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 1};
        //time complexity =0(n^2)
        //Insert  Sort
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            //placement
            arr[j + 1] = current;
        }
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println(" ");
    }
}
