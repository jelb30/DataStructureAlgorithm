package problems.dynamic_programming;
public class LC0198HouseRobber {

    public int rob(int[] nums) {

        int prev1 = 0;  // 1 HOUSE AGO
        int prev2 = 0;  // 2 HOUSES AGO

        for(int money: nums) {

            //EITHER SKIP IT AND KEEP IT TILL PREV1, OR ROB AND KEEP IT TILL PREV2
            int current = Math.max(prev1, prev2 + money);

            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
