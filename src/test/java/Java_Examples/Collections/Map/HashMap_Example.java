package Java_Examples.Collections.Map;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Two Sum: Find two numbers in an array that add to a given target using a
 * hasMap for efficient an return the indices of the two numbers such that they add up to target
 * */

public class HashMap_Example {

    public static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int extra = target - nums[i];
            if (numMap.containsKey(extra)) {
                return new int[]{numMap.get(extra), i};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

        int nums[] = {2, 11, 5, 4, 20};
        int target = 25;
        int result[] = findTwoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
