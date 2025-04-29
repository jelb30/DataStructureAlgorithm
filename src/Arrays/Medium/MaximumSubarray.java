package Arrays.Medium;

// KADANE'S ALGORITHM.
// LEETCODE PROBLEM NUMBER 53.
// COMPLEXITY OF 0(N).

public class MaximumSubarray {

    public static void main(String[] args) {

        int[] nums = new int[]{5,4,-1,7,8};

        maxSubArray(nums);
    }

    // simple yet very efficient algorithm.
    public static int maxSubArray(int[] nums) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            sum+=nums[i];

            if(sum > max){
                max = sum;
            }

            if(sum<0){
                sum = 0;
            }
        }

        return max;
    }
}
