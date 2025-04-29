package Arrays.Medium;


// LEETCODE PROBLEM NUMBER 334.

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,0,4,6};
        boolean found = increasingTriplet(nums);
        System.out.println(found);
    }

    private static boolean increasingTriplet(int[] nums) {

        int smallest = nums[0];
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if(smallest >= nums[i]){
                smallest = nums[i];
                secondSmallest = smallest;
                continue;
            }

            if (nums[i] > smallest && nums[i] < secondSmallest) {
                secondSmallest = nums[i];
                continue;
            }

            return true;

        }
        return false;
    }

    // BRUTE FORCE!
    public static boolean bruteIncreasingTriplet(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                if(nums[j] <= nums[i]){
                    continue;
                }
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[k] <= nums[j]){
                        continue;
                    }
                    if(nums[i] < nums[j] && nums[j] < nums[k]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
