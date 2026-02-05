package Arrays.Easy;


//LEETCODE PROBLEM NUMBER 35.
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        searchInsert(nums, 6);
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        int mid= -1;

        while(start<=end){

            mid = (start+end)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        if(target > nums[mid] && target < nums[mid+1]){
            return mid+1;
        }else{
            return mid;
        }

    }
}
