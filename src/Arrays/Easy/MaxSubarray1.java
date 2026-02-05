package Arrays.Easy;

// leetcode problem number 643.

public class MaxSubarray1 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        System.out.println(maxAvgPrefixSum(nums, 1));
    }

    //BASIC SOLUTION.
    public static double findMaxAverage(int[] nums, int k) {

        double maxAvg = (double) Integer.MIN_VALUE;

        for (int i = 0; i <= nums.length-k; i++) {
            int tempCount = 0;
            int tempSum = 0;
            while(tempCount!=k){
                tempSum+=nums[i+tempCount];
                tempCount++;
            }
            if((double)tempSum/k > maxAvg){
                maxAvg = (double)tempSum/k;
            }
        }

        return maxAvg;

    }


    //USING PREFIX SUM
    public static double maxAvgPrefixSum(int[] nums, int k){
        double maxAvg = (double) Integer.MIN_VALUE;
        int[] prefixArr = new int[nums.length];
        prefixArr[0] = nums[0];
        // PREFIX SUM
        for (int i = 1; i < nums.length; i++) {
            prefixArr[i] = nums[i] + prefixArr[i-1];
        }

        int currentInt = 0;
        int index = 0;
        for (int i = k-1; i < prefixArr.length; i++) {
            int currentSum = prefixArr[i]-currentInt;
            if((double) currentSum/k > maxAvg){
                maxAvg = (double) currentSum/k;
            }
            currentInt+=nums[index++];
        }

        return maxAvg;

    }
}
