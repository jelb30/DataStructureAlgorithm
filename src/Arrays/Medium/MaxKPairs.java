package Arrays.Medium;

// LEETCODE PROBLEM NUMBER 1679

import java.util.*;

public class MaxKPairs {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 3, 4, 3};
        int steps = maxOperations(nums, 6);
        System.out.println(steps);
    }

    public static int maxOperations(int[] nums, int k) {
        //SORTING SO WE CAN USE 2 POINTERS.
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int steps = 0;

        while (start < end) {
            //CURRENT SUM.
            int tempSum = nums[start] + nums[end];
            if (tempSum == k) { // IF THE SUM IS SAME THEN WE REMOVE THEM. AND STEP++.
                steps++;
                start++;
                end--;
                continue;
            }
            if (tempSum > k) {
                end--;
                continue;
            }
            start++;
        }

        return steps;
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Set<Integer> occurrences = new HashSet<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int occurrence : countMap.values()) {
            occurrences.add(occurrence);
        }

        return occurrences.size() == countMap.size();
    }
}