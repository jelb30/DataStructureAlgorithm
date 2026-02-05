package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        implementation();
    }

    public static List<Integer> indexes;

    public static void implementation() {

        indexes = new ArrayList<>();
        int[] sortedArr = {1,6,9,14,19, 19, 19,36,78,101};
        int target = 19;

        int result = binarSearchAlgo(sortedArr, target, 0, sortedArr.length-1);
        System.out.println(target+" --> "+result);

        for(Integer num: indexes){
            System.out.println(num);
        }

    }

    public static int binarSearchAlgo(int[] sortedArr,int target, int start, int end){
        if(start>end){
            return -1;
        }

        int median = (start+end)/2;

        if (target == sortedArr[median]) {
            indexes.add(median);
        }

        if(target>sortedArr[median]){
            return binarSearchAlgo(sortedArr, target, median+1, end);
        }

        return binarSearchAlgo(sortedArr, target, start, median-1);
    }

}
