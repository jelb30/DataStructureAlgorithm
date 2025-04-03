package Arrays.Easy;

import java.util.*;

public class SmallerThanCurrentNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{7,7,7,7};
        implement(nums);
    }

    public static int[] implement(int[] nums){

        // CLONING THE ARRAY, TO NOT CHANGE THE MAIN ARRAY!
        int[] copyArr = nums.clone();
        Arrays.sort(copyArr); //SORTING THE COPY! NEEDDED TO ACHEIEVE THE VALUES ASKED!

        Map<Integer, Integer> sortedIndexMap = new HashMap<>(); // MAP TAKSE ELEMENTS AS KEYS AND INDEXES AS VALUES.
        int sortedIndex = 0;
        int duplicateCounter=0; // DUPLICATE COUNTER SO IF DUPLICATES THEN ADD DUPLICATES TO THE INDEX FOR VALUES.

        // GENERATING THE MAP!
        for (int num : copyArr) {
            if(sortedIndexMap.containsKey(num)){
                duplicateCounter++;
                continue;
            }
            if(duplicateCounter>0){
                sortedIndexMap.putIfAbsent(num, sortedIndex+duplicateCounter);
            }
            sortedIndexMap.putIfAbsent(num, sortedIndex++);
        }

        for (int i = 0; i < copyArr.length; i++) {

            nums[i] = sortedIndexMap.get(nums[i]);
        }

        for(int num: nums){
            System.out.println(num);
        }

        return nums;
    }
}
