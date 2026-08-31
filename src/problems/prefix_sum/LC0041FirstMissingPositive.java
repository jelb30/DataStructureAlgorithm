package problems.prefix_sum;
import java.util.Arrays;


public class LC0041FirstMissingPositive {

    // ALSO WORKS AS TIME AND SPACE COMPLEXITY B0TH ARE N.
    public int firstMissingPositive(int[] nums) {

        int size = nums.length;
        boolean[] seen = new boolean[size + 1];
        seen[0] = true;

        for(int num: nums) {
            if(num > 0 && num <  size + 1) {
                seen[num] = true;
            }
        }

        for (int i = 0; i < size + 1 ; i++) {
            if(!seen[i]) return i;
        }

        return size + 1;
    }

    // WORKS WITH THE TIME -> NLONG , SPACE -> CONSTANT!
    public int bruteForce(int[] nums) {

        Arrays.sort(nums);
        int currInt = 1;
        int prevNum = Integer.MIN_VALUE;
        for(int i: nums) {
            if(i <= 0 || i == prevNum ) {
                continue;
            }
            if(i == currInt) {
                currInt++;
                prevNum = i;
                continue;
            }
            return currInt;
        }
        return currInt;
    }
}
