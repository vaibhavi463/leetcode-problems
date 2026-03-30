class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum + target) % 2 != 0 || sum < Math.abs(target)) {
            return 0;
        }

        int P = (sum + target) / 2;

        int[] dp = new int[P + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = P; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[P];
    }
}