package problems.two_pointers;
// LeetCode problem number 1920.
public class LC1920BuildArrayFromPermutation {

    public int[] implementation(int[] nums){

        int[] modifiedArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            modifiedArr[i] = nums[nums[i]];
        }

        return modifiedArr;
    }
}
