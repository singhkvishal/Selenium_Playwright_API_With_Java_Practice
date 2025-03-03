package Java_Examples.DataStructures;
import java.util.HashMap;

public class HashMap_Example {
    public static void main(String[] args) {
        // Create a HashMap to store String keys and Integer values
        HashMap<String, Integer> hashMap = new HashMap<>();

        // Add key-value pairs to the HashMap
        hashMap.put("John", 25);
        hashMap.put("Alice", 30);
        hashMap.put("Bob", 35);

        //Access and print values based on keys
        System.out.println("Age of John:" + hashMap.get("John"));
        System.out.println("Age of Alice:" + hashMap.get("Alice"));

        // Check if a key exists in the HashMap
        System.out.println("Is Bob present?" + hashMap.containsKey("Bob"));

        // Update the value associated with a key
        hashMap.put("Alice", 32);

        // Remove a key-value pair from the HashMap
        hashMap.remove("John");

        // Print all key-value pairs in the HashMap
        System.out.println("Key-Value pairs in the HashMap:");
        for (String key : hashMap.keySet()) {
            System.out.println(key + ":" + hashMap.get(key));
        }

        // Check the size of the HashMap
        System.out.println("Size of the HashMap:" + hashMap.size());
    }
}
