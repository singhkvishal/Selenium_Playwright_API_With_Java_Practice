package Java_Examples.arrays;

public class SecondHighestNumber {
    public static void main(String[] args) {
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
}
