package problems.prefix_sum;
import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;

public class LC0001TwoSum {

    public static void main(String[] args) {

        int[] arr = new int[]{2,7,11,15};
        int target = 9;

        int[] indexes = twoSum(arr,target);
        System.out.println(Arrays.toString(indexes));

    }

    public static int[] twoSum(int[] arr, int target) {
        int[] indexes = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(target-arr[i])){
                indexes[0] = map.get(target-arr[i]);
                indexes[1] = i;
                break;
            }
        }
        return indexes;
    }
}
