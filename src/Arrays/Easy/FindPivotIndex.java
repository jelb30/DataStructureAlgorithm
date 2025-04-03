package Arrays.Easy;

// LEETCODE PROBLEM 724.
public class FindPivotIndex {

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        System.out.println(implementation(nums));;
    }

    public static int implementation(int[] nums){

        int len = nums.length;

        for (int i = 1; i < len; i++) {
            nums[i]+=nums[i-1];
        }

        int totalSum = nums[len-1];

        for (int i = 1; i < len; i++) {
            if(totalSum-nums[i]==nums[i-1]) return i;
        }

        return -1;
    }
}
