package Arrays.Medium;

// LEETCODE VERSION OF SORT ARRAY OF 0, 1 AND 2S. PROBLEM NO.75
// DUTCH NATIONAL FLAG ALGORITHM.
public class SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        implementation(nums);
    }

    // 3 POINTERS.
    public static void implementation(int[] nums){

        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(high>=mid){
            int currentNum = nums[mid];

            if (currentNum==0){
                int temp = nums[low];
                nums[low++] = currentNum;
                nums[mid++] = temp;
                continue;
            }

            if(currentNum==1){
                mid++;
                continue;
            }

            int temp = nums[high];
            nums[high--] = 2;
            nums[mid] = temp;
        }

        for(int num: nums){
            System.out.println(num);
        }
    }
}
