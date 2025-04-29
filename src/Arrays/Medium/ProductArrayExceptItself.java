package Arrays.Medium;

//LEETCODE PROBLEM NUMBER 238.

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class ProductArrayExceptItself {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,0,-3,3};
        productExceptSelf(nums);
    }

    public static int[] productExceptSelf(int[] nums) {

        int product = 1;
        boolean zeroPresent = false;

        //GETTING PRODUCT.
        for(int num: nums){
            if(num==0) continue;
            product*=num;
        }

        System.out.println("PRODUCT: "+product);

        //CHECKING IF THERE IS ANY ZEROS OR NOT.
        for (int num: nums){
            if(num==0){
                zeroPresent = true;
                break;
            }
        }

        if(zeroPresent){

            int zeroCount = 0;
            for(int num: nums){
                if(num==0) zeroCount++;
            }

            if(zeroCount > 1){
                for (int i = 0; i < nums.length; i++) {
                    nums[i]=0;
                }
                return nums;
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
}
