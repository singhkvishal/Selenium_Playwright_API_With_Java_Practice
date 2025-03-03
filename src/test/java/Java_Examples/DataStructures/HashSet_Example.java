package Java_Examples.DataStructures;

import java.util.HashSet;
import java.util.Set;

public class HashSet_Example {
    public static void main(String[] args) {
        // Create a HashSet
       //  Set<String> set = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        // Add elements to the HashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Grapes");
        set.add("Mango");

        // Print the HashSet
        System.out.println("HashSet:" + set);

        // Check if an element exists
        System.out.println("Contains 'Apple':" + set.contains("Apple"));

        // Remove an element
        set.remove("Banana");

        // Print the updated HashSet
        System.out.println("Updated HashSet:" + set);

        // Get the size of the HashSet
        System.out.println("Size of HashSet:" + set.size());

        // Clear the HashSet
        set.clear();

        // Check if the HashSet is empty
        System.out.println("Is HashSet empty?" + set.isEmpty());
    }
}