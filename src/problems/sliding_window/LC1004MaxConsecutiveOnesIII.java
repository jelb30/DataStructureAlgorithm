package problems.sliding_window;
public class LC1004MaxConsecutiveOnesIII {


    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int max = longestOnes(nums, 2);
        System.out.println(max);
    }

    public static int longestOnes(int[] nums, int k) {

        int maxCount = 0;

        int leftPointer = 0;
        int rightPointer =0;

        int zeroCount = 0;

        while(rightPointer< nums.length){
            if(nums[rightPointer]==0){
                zeroCount++;
            }

            while(zeroCount>k){
                if(nums[leftPointer]==0){
                    zeroCount--;
                }
                leftPointer++;
            }

            maxCount = Math.max(maxCount, rightPointer-leftPointer+1);
            rightPointer++;
        }

        return maxCount;

    }
}
