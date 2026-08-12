package problems.arrays.matrix;

// LEETCODE QUESTION 1672
public class LC1672RichestCustomerWealth {

    public int implementation(int[][] nums){

        int highestWealth = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < nums[0].length; j++) {
                temp+= nums[i][j];
            }
            if(temp>highestWealth) highestWealth= temp;
        }

        return highestWealth;
    }
}
