package Arrays.Easy;

// LEETCODE PROBLEM 1470.

public class ShuffleTheArray {

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,1,3,4,7};
        nums = implementation(nums, 3);

        for(int num: nums){
            System.out.print(num+", ");
        }
    }

    public static int[] implementation(int[] nums, int n){

        int[] newArr = new int[2*n];

        int lefPart = 0;
        int rightPart = 0;

        for (int i = 0; i < 2*n; i++) {

            if(i%2==0){
                newArr[i] = nums[lefPart++];
            }else{
                newArr[i] = nums[rightPart+n];
                rightPart++;
            }

        }

        return newArr;
    }
}
