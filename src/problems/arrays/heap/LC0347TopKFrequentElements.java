package problems.arrays.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC0347TopKFrequentElements {

    public static void main(String[] args) {

    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int size = map.keySet().size();
        List<Integer>[] bucketList = new List[nums.length +1];

        for(int element: map.keySet()) {
            int index = map.get(element);
            if(bucketList[index] == null) {
                bucketList[index] = new ArrayList<>();
            }
            bucketList[index].add(element);
        }

        int[] result = new int[k];
        int resultIndex = 0;

        for (int i = bucketList.length-1; i >= 0 && resultIndex < k ; i--) {
            if(bucketList[i] != null) {
                for(int element : bucketList[i]) {
                    result[resultIndex++] = element;
                }
            }
        }
        return result;

    }
}
