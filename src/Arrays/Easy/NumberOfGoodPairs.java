package Arrays.Easy;

public class NumberOfGoodPairs {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,2,2,2,2};
        implementation(nums);
    }

    public static int implementation(int[] nums){

        int goodPairs = 0;

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]) goodPairs++;
            }
        }
        System.out.println(goodPairs);
        return goodPairs;
    }
}
