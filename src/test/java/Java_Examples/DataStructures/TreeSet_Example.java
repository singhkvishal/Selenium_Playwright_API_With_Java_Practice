package Java_Examples.DataStructures;

import java.util.TreeSet;

public class TreeSet_Example {
    public static void main(String[] args) {
        // Create a TreeSet
        TreeSet<Integer> numbers = new TreeSet<>();

        // Add elements to the TreeSet
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(4);
        numbers.add(4);
        numbers.add(4);
        // Print the TreeSet
        System.out.println("Elements in the TreeSet:" + numbers);

        // Check if an element exists
        System.out.println("Does TreeSet contain 4?" + numbers.contains(4));

        // Remove an element
        numbers.remove(2);

        // Print the TreeSet after removal
        System.out.println("Elements in the TreeSet after removal:" + numbers);

        // Get the size of the TreeSet
        System.out.println("Size of the TreeSet:" + numbers.size());

        // Get the first and last element
        System.out.println("First element:" + numbers.first());
        System.out.println("Last element:" + numbers.last());

        // Iterate over the TreeSet
        System.out.println("Iterating over the TreeSet:");
        /*for (int number : numbers) {
            System.out.println(number);
        }*/

        numbers.forEach(System.out::println);
    }
}
