package Recursion.Medium;

public class BinarySearch {

    public void implementation() {

        int[] sortedArr = {1,6,9,14,19,36,78,101,106};
        int target = 106;

        int result = binarSearchAlgo(sortedArr, target, 0, sortedArr.length-1);
        System.out.println(target+" --> "+result);

    }

    public int binarSearchAlgo(int[] sortedArr,int target, int start, int end){
        if(start>end){
            return -1;
        }

        int median = (start+end)/2;

        if (target == sortedArr[median]) {
            return median;
        }

        if(target>sortedArr[median]){
            return binarSearchAlgo(sortedArr, target, median+1, end);
        }

        return binarSearchAlgo(sortedArr, target, start, median-1);
    }

}
