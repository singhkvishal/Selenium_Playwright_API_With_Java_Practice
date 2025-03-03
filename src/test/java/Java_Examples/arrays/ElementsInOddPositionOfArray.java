package Java_Examples.arrays;
import org.junit.Test;

import java.util.Arrays;

public class ElementsInOddPositionOfArray {
	@Test
	public void UsingForWithIF(){
		//Print the Elements of an Array Present on Odd Position

		int arr[] = {98, 39, 23, 32, 121, 25, 64, 88, 67, 47, 12, 13, 23, 34, 75, 66};
		System.out.println("===============================");
		System.out.println("UsingForWithIF-Input 2D Array");
		System.out.println(Arrays.toString(arr));

		System.out.println("Elements in Odd positions of the Array");
		for (int i = 0; i < arr.length; i++)
			if (i % 2 == 0)
				System.out.print(arr[i] + " ");
	}

	@Test
	public void ForLoopIncrement(){
		int arr[] = {98, 39, 23, 32, 121, 25, 64, 88, 67, 47, 12, 13, 23, 34, 75, 66};
		System.out.println("========================");
		System.out.println("ForLoopIncrement-Input 2D Array");
		System.out.println(Arrays.toString(arr));

		System.out.println("Elements in Odd positions of the Array");
		for (int i = 0; i < arr.length; i=i+2)
				System.out.print(arr[i] + " ");
	}

	@org.testng.annotations.Test
	public void EvenNumbers() {
		int arr[] = {33, 54, 12, 22, 33, 78, 99, 3, 12, 78, 90, 99, 15, 2, 3, 90, 22, 56};

		Arrays.stream(arr).filter(o -> o % 2 == 0).forEach(System.out::println);
	}
}
