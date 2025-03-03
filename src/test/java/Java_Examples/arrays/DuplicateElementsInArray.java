package Java_Examples.arrays;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DuplicateElementsInArray {
	@Test
	public void Test() {
		int arr[] = {33, 54, 12, 22, 33, 78, 99, 3, 12, 78, 90, 99, 15, 2, 3, 90, 22, 56};

		System.out.println("Values In Array");
		System.out.println(Arrays.toString(arr));

		System.out.println("\nDuplicate Elements in Array are below");
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					System.out.print(arr[j] + " ");
				}
			}
		}
	}



	@Test
	public void DuplicateElements() {
		List<Integer> itemsList = Arrays.asList(10, 12, 10, 33, 40, 40, 61, 61);
		Set<Integer> newitemSet = new HashSet<>();

		System.out.println("The list of duplicate Items: ");
		itemsList.stream().filter(nums -> !newitemSet.add(nums)).forEach(System.out::println);

		newitemSet.clear();
		System.out.println("Remove the duplicate Items: ");
		itemsList.stream().filter(nums -> newitemSet.add(nums)).forEach(System.out::println);
	}
}