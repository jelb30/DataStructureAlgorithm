package Arrays.Medium;


// LEETCODE PROBLEM NUMBER 11.
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        int max  = maxArea(nums);
        System.out.println(max);

    }

    public static  int maxArea(int[] height) {

        int maxWater = 0;
        int start = 0;
        int end = height.length-1;

        while(start<end){
            int m = Math.min(height[start], height[end]);
            int n = end - start;
             if(maxWater < n*m){
                 maxWater = n * m;
             }

             if(height[start] <= height[end]){
                 start++;
             }else{
                 end--;
             }
        }

        return maxWater;

    }


}
