class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
       
        int n = startTime.length;

        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n];
        return solve(0, jobs, dp);
    }

    private int solve(int i, int[][] jobs, int[] dp) {

        if (i >= jobs.length) return 0;

        if (dp[i] != 0) return dp[i];

        // skip
        int skip = solve(i + 1, jobs, dp);

        // take
        int next = findNext(i, jobs);
        int take = jobs[i][2] + solve(next, jobs, dp);

        return dp[i] = Math.max(skip, take);
    }

    private int findNext(int i, int[][] jobs) {

        int low = i + 1, high = jobs.length - 1;
        int target = jobs[i][1];
        int ans = jobs.length;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (jobs[mid][0] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}