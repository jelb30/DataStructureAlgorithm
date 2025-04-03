package Arrays.Easy;

// LeetCode problem number 1929.
public class ConcatenationOfArray {

    public int[] implementation(int[] nums){
        int[] newArr = new int[nums.length*2];

        int numsIndex = 0;

        for (int i = 0; i < newArr.length; i++) {

            newArr[i] = nums[nums[numsIndex]];

            if(numsIndex == nums.length-1) numsIndex=0;
            else numsIndex++;

        }

        return newArr;
    }
}
