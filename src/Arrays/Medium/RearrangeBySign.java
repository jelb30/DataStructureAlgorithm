package Arrays.Medium;


//LEETCODE PROBLEM NUMBER 2149.
public class RearrangeBySign {

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,-2,-5,2,-4};

        rearrangeArray(nums);
    }

    public static int[] rearrangeArray(int[] nums) {

        int[] result = new int[nums.length];

        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                result[positiveIndex] = nums[i];
                positiveIndex+=2;
                continue;
            }
            result[negativeIndex] = nums[i];
            negativeIndex+=2;
        }

        for(int num: result){
            System.out.println(num);
        }

        return result;
    }

}
