class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
    
        for (int n : nums)
            max = Math.max(max, n);

        int[] points = new int[max + 1];

        for (int n : nums)
            points[n] += n;

        int prev2 = 0;
        int prev1 = 0;

        for (int i = 0; i <= max; i++) {
            int curr = Math.max(prev1, prev2 + points[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}