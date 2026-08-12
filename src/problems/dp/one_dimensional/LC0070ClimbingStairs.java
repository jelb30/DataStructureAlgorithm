package problems.dp.one_dimensional;

public class LC0070ClimbingStairs {

    public int climbStairs(int n) {
        // Edge cases: 1 or 2 steps have 1 and 2 ways respectively.
        if (n <= 2) return n;

        // Only the last two values matter, so track just those. O(1) space.
        int prev = 1;   // ways to reach step 1
        int curr = 2;   // ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int next = prev + curr;   // ways(i) = ways(i-1) + ways(i-2)
            prev = curr;
            curr = next;
        }

        return curr;
    }
}
