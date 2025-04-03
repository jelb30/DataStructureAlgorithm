package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberCandies {

    public static void main(String[] args) {

        int[] nums = new int[]{2,3,5,1,3};


    }

    public static List<Boolean> implementation(int[] nums, int n){

        int len = nums.length;
        List<Boolean> greatestCandiesCheck = new ArrayList<>();

        //FINDING THE MAX CANDIES IN THE ARRAY AND ADDING THE EXTRA CANDIES IN THE ARRAY!
        int maxCandies = -1;

        for (int i = 0; i < len; i++) {
            if(nums[i]>maxCandies) maxCandies=nums[i];
            nums[i]+=n;
        }

        // FILLING BOOLEAN ARRAY FOR CHECKING MAX CANDIES AFTER ADDING EXTRAS!
        for (int i = 0; i < len; i++) {
            if(nums[i] >= maxCandies) greatestCandiesCheck.add(true);
            else greatestCandiesCheck.add(false);
        }

        return greatestCandiesCheck;
    }
}
