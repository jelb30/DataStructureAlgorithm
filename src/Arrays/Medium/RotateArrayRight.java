package Arrays.Medium;

public class RotateArrayRight {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4,5,6,7};
        RotateArrayRight object = new RotateArrayRight();
        object.rotate(nums, 4);

        for(int num: nums){
            System.out.print(num+", ");
        }
    }

    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverseSubArr(0, nums.length-k-1, nums );
        reverseSubArr(nums.length-k, nums.length-1, nums);
        reverseSubArr(0, nums.length-1, nums);
    }

    public void reverseSubArr(int startIndex, int endIndex, int[] nums){
        if (startIndex>=endIndex){
            return;
        }

        int temp = nums[startIndex];
        nums[startIndex] = nums[endIndex];
        nums[endIndex] = temp;
        reverseSubArr(startIndex+1, endIndex-1, nums);
    }

}
