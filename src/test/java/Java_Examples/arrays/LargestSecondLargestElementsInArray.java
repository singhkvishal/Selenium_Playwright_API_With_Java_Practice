package Java_Examples.arrays;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LargestSecondLargestElementsInArray {
	@Test
	public void SecondLargestNumber() {
		int arr[] = {2438, 232, 12345, 567, 343, 98, 875, 712, 475, 33, 88, 97, 56, 2, 44, 8723, 7237, 99999};

		System.out.println("Array values");
		System.out.println(Arrays.toString(arr));
		int largest1 = 0, largest2 = 0;

		largest1 = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > largest1)
				largest1 = arr[i];
		}

		System.out.println("Largest number in array: " + largest1);

		largest2 = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > largest2 && arr[i] < largest1)
				largest2 = arr[i];
		}

		System.out.println("Second Largest number in array: " + largest2);
	}

	@Test
	public void SecondLargestNumber_Stream() {
		List<Integer> numbers = Arrays.asList(10, 20, 35, 50, 50, 75, 65);

		// Step 1: Find the second largest number in the list
		Optional<Integer> secondLargest = numbers.stream()
				.distinct() // Step 2: Remove duplicates
				.sorted(Comparator.reverseOrder()) // Step 3: Sort in descending order
				.skip(1) // Step 4: Skip the first (largest) number
				.findFirst(); // Step 5: Get the second largest number
		System.out.println("The second largest number is: " + secondLargest.get());
	}
}
