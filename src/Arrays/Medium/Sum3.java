package Arrays.Medium;

import javax.swing.plaf.TreeUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        int target = 0;

        for(List<Integer> list: threeSum(nums)){
            for(int num: list){
                System.out.print(num+",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> finalList = new ArrayList<>();
        if(nums.length<3){
            return finalList;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {

            int currentVal = nums[i];
            int leftPointer = i+1;
            int rightPointer = nums.length-1;

            if(i>0 && currentVal==nums[i-1]){
                continue;
            }

            while(leftPointer<rightPointer){
                if(currentVal+nums[leftPointer]+nums[rightPointer]>0){
                    rightPointer--;
                    continue;
                }

                if(currentVal+nums[leftPointer]+nums[rightPointer]<0){
                    leftPointer++;
                    continue;
                }

                List<Integer> tempList = new ArrayList<>();
                 tempList.add(currentVal);
                 tempList.add(nums[leftPointer]);
                 tempList.add(nums[rightPointer]);
                 finalList.add(tempList);
                 leftPointer++;

                 while(nums[leftPointer]==nums[leftPointer-1] && leftPointer<rightPointer){
                     leftPointer++;
                 }

            }



        }
        return finalList;
    }

}
