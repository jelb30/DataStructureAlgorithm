package Arrays.Easy;


// LEETCODE QUESTION NUMBER 121.
public class BestTimeStock {

    public static void main(String[] args) {
        int[] prices = new int[]{2,1,2,0,1};

        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // update min so far
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }




}
