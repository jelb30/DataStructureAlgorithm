package Arrays.Easy;

public class RunningSum1D {

    public int[] implmentationm(int[] nums){

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }

        return nums;
    }
}
