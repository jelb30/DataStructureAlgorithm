package Arrays.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LEETCODE PROBLEM NUMBER 229
public class MajorityElement2 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3};

        majorityElement(nums);

    }

    public static List<Integer> majorityElement(int[] nums) {

        List<Integer> finalList = new ArrayList<>();

        if(nums.length<2){
            finalList.add(nums[0]);
            return finalList;
        }

        if(nums.length<3){
            if(nums[0]!=nums[1]){
                for(int num: nums){
                    finalList.add(num);
                }
                return finalList;
            }
        }


        for (int i = 0; i < nums.length; i++) {

            int count = 1;
            int element = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]==element){
                    count++;
                }
            }

            if(count > nums.length/3){
                if(finalList.contains(element)){
                    continue;
                }
                finalList.add(element);
            }
        }

        for (int num: finalList){
            System.out.println(num);
        }

        return finalList;

    }
}
