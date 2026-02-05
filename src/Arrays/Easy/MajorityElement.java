package Arrays.Easy;

// LEET CODE PROBLEM NUMBER 169
// MOORE'S VOTING ALGORITHM
public class MajorityElement {

    public static void main(String[] args) {

        int[] nums = new int[]{0,3,4,0};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {

        int element = -1;
        int tempCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if(tempCount==0){
                element = nums[i];
            } else if (nums[i]==element) {
                tempCount++;
            }else{
                tempCount--;
            }
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==element){
                count++;
            }
        }

        if(count > nums.length/2){
            return element;
        }

        return -1;


    }
}
