package Arrays.Medium;

// LEETCODE PROBLEM NUMBER 33.
public class SearchInRotated {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
        ;
    }

    public static int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;

        while(start<=end){

            int middle = (start+end) / 2;

            if(nums[middle]==target){
                return middle;
            }

            if(nums[start] <= nums[middle]){

                if(nums[start] <= target && nums[middle] > target){
                    end = middle-1;
                }
                else{
                    start = middle+1;
                }
            }else{
                if(target > nums[middle] && target <= nums[end]){
                    start = middle+1;
                }
                else{
                    end = middle-1;
                }
            }

        }

        return -1;
    }

}
