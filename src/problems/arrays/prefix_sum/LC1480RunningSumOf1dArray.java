package problems.arrays.prefix_sum;

public class LC1480RunningSumOf1dArray {

    public int[] implmentationm(int[] nums){

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }

        return nums;
    }
}
