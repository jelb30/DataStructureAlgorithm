package Arrays.Easy;

// LEET CODE 1389


public class TargetArraayInGivenOrder {

    public static int[] target;

    public static void main(String[] args) {

        int[] nums = new int[]{0,1,2,3,4};
        int[] index = new int[]{0,1,2,2,1};

        generatingTargetArray(nums, index);

        for(int num: target){
            System.out.println(num);
        }
    }

    public static int[] generatingTargetArray(int[] nums, int[] index){
        target = new int[nums.length];

        for (int i = 0; i < index.length; i++) {
            if(i != index[i]){
                SlidingValues(index[i], nums[i]);
                continue;
            }

            target[index[i]] = nums[i];
        }

        return target;
    }

    public static void SlidingValues(int index, int number){
        if(index==target.length){
            return;
        }
        int temp = target[index];
         target[index] = number;
         SlidingValues(index+1, temp);
    }
}
