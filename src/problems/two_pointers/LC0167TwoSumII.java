package problems.two_pointers;
public class LC0167TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int[] results = new int[2];
        int left = 0;
        int right = numbers.length-1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                results[0] = left;
                results[1] = right;
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }
        return results;
    }

}
