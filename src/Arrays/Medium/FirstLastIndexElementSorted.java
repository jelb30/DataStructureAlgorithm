package Arrays.Medium;

// LEET CODE PROBLEM NUMBER 34
public class FirstLastIndexElementSorted {

    public static void main(String[] args) {

        int[] indexes = new int[]{-1,-1};
    }

    public static int binarySearchAlgo(int[] sortedArr, int target, int start, int end, boolean findFirst) {
        if (start > end) {
            return -1;
        }

        int median = (start + end) / 2;

        if (sortedArr[median] == target) {
            // Continue searching left or right depending on findFirst
            int result = median;
            if (findFirst) {
                int leftResult = binarySearchAlgo(sortedArr, target, start, median - 1, true);
                return (leftResult != -1) ? leftResult : result;
            } else {
                int rightResult = binarySearchAlgo(sortedArr, target, median + 1, end, false);
                return (rightResult != -1) ? rightResult : result;
            }
        }

        if (target > sortedArr[median]) {
            return binarySearchAlgo(sortedArr, target, median + 1, end, findFirst);
        } else {
            return binarySearchAlgo(sortedArr, target, start, median - 1, findFirst);
        }
    }



}
