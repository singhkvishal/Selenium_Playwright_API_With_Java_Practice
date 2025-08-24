package Java_Examples.DataStructures;

import java.util.LinkedList;

public class LinkedList_Example {
    public static void main(String[] args) {
        // Create a LinkedList to store integers
        LinkedList<Integer> linkedList1 = new LinkedList<>();

        // Add elements to the LinkedList
        linkedList1.add(10);
        linkedList1.add(20);
        linkedList1.add(30);
        linkedList1.add(40);
        linkedList1.add(50);

        // Print the LinkedList
        System.out.println("LinkedList:"+ linkedList1 );

        // Remove an element from the LinkedList
        linkedList1.removeFirst();
        System.out.println("LinkedList after removing first element:" + linkedList1);

        // Check if an element exists in the LinkedList
        boolean containsElement = linkedList1.contains(30);
        System.out.println("LinkedList contains element 30?" + containsElement);

        // Get the first and last elements of the LinkedList
        int firstElement = linkedList1.getFirst();
        int lastElement = linkedList1.getLast();
        System.out.println("First element:" + firstElement);
        System.out.println("Last element:" + lastElement);

        for (Integer integer : linkedList1) {
            System.out.println(integer);
        }
        // Clear the LinkedList
        linkedList1.clear();
        System.out.println("LinkedList after clearing:" + linkedList1);
    }
}
