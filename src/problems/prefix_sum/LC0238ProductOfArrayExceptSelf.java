package problems.prefix_sum;
//LEETCODE PROBLEM NUMBER 238.

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class LC0238ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,0,0,3};
        for (int i: productExceptSelf2(nums)){
            System.out.println(i);
        }
    }

    //NOT ALLOWED SOLUTION.
    public static int[] productExceptSelf(int[] nums) {

        int product = 1;
        boolean zeroPresent = false;

        //GETTING PRODUCT.
        for(int num: nums){
            if(num==0) {
                zeroPresent = true;
                continue;
            }
            product*=num;
        }

        System.out.println("PRODUCT: "+product);

        if(zeroPresent){

            int zeroCount = 0;
            for(int num: nums){
                if(num==0) zeroCount++;
            }

            if(zeroCount > 1){
                for (int i = 0; i < nums.length; i++) {
                    nums[i]=0;
                }
                //return nums;
            }

            for (int i = 0; i < nums.length; i++) {
                if(nums[i]==0) nums[i] = product;
                else nums[i] = 0;
                System.out.println(nums[i]);
            }

            return nums;

        }
        else{
            for (int i = 0; i < nums.length; i++) {
                nums[i] = product/nums[i];
                System.out.println(nums[i]);
            }
            return nums;
        }

    }

    public static int[] productExceptSelf2(int[] nums) {
        int size = nums.length;
        int[] results = new  int[size];

        results[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
            //System.out.println(results[i]);
        }

        int suffix =1;
        for (int i = size-1; i >= 0; i--) {
            results[i] = suffix * results[i];
            suffix *= nums[i];
        }
        return results;

    }


}
