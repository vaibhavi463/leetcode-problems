import java.util.Arrays;
class Solution {
     int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);

        return Math.min(solve(0, cost), solve(1, cost));
    }

    public int solve(int i, int[] cost) {

        if (i >= cost.length) return 0;

        if (dp[i] != -1) return dp[i];

        int a = cost[i] + solve(i + 1, cost);
        int b = cost[i] + solve(i + 2, cost);

        dp[i] = Math.min(a, b);
        return dp[i];
    }
}
