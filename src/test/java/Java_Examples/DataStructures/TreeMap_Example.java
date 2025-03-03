package Java_Examples.DataStructures;

import java.util.TreeMap;

public class TreeMap_Example {
    public static void main(String[] args) {
        // Create a TreeMap
        TreeMap<String, Integer> scores = new TreeMap<>();

        // Insert key-value pairs into the TreeMap
        scores.put("Alice", 90);
        scores.put("Bob", 80);
        scores.put("Charlie", 95);
        scores.put("David", 87);
        scores.put("Eve", 92);

        //Access and print values from the TreeMap
       // System.out.println("Score of Alice:" + scores.get("Alice"));
       // System.out.println("Score of Charlie:" + scores.get("Charlie"));
       // System.out.println("Score of David:" + scores.get("David"));
        for (String name : scores.keySet()) {
            int score = scores.get(name);
            System.out.println(name + ":" + score);
        }
        // Update a value in the TreeMap
        scores.put("Bob", 85);

        // Remove a key-value pair from the TreeMap
        scores.remove("Eve");

        // Iterate through the TreeMap using a for-each loop
        System.out.println("Scores in the TreeMap:");
        for (String name : scores.keySet()) {
            int score = scores.get(name);
            System.out.println(name + ":" + score);
        }
    }
}
