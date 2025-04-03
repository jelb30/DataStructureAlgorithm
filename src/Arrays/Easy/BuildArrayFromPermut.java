package Arrays.Easy;

// LeetCode problem number 1920.
public class BuildArrayFromPermut {

    public int[] implementation(int[] nums){

        int[] modifiedArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            modifiedArr[i] = nums[nums[i]];
        }

        return modifiedArr;
    }
}
