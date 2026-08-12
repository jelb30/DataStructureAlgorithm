package problems.arrays.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class LC0560SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> notebook = new HashMap<>();
        notebook.put(0, 1);
        int total = 0;
        int answer = 0;

        for (int num : nums) {
            total += num;

            if (notebook.containsKey(total - k)) {
                answer += notebook.get(total - k);
            }

            notebook.merge(total, 1, Integer::sum);
        }
        return answer;
    }
}
