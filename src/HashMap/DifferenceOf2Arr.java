package HashMap;


// LEETDODE PROBLEM NUMBER 2215.

import java.util.*;

public class DifferenceOf2Arr {

    public static void main(String[] args) {

    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> resultList = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        List<Integer> list2 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();


        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        for(int num: set1){
            if(!set2.contains(num)){
                list1.add(num);
            }
        }

        for(int num: set2){
            if(!set1.contains(num)){
                list2.add(num);
            }
        }

        resultList.add(list1);
        resultList.add(list2);

        return resultList;
    }
}


