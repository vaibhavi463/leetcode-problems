class Solution {
    

    static final int MOD = 1000000007;

    List<Integer>[] tree;
    int[] nums;
    int k;

    public int countValidSubsets(int[] parent, int[] nums, int k) {

        int[][] zentharuic = new int[1][1];

        int n = parent.length;

        this.nums = nums;
        this.k = k;

        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        long[][] res = dfs(0);

        long ans = res[0][0] + res[1][0] - 1;

        ans %= MOD;

        if (ans < 0) {
            ans += MOD;
        }

        return (int) ans;
    }

    private long[][] dfs(int node) {

        long[] notTake = new long[k];
        long[] take = new long[k];

        notTake[0] = 1;

        take[nums[node] % k] = 1;

        for (int child : tree[node]) {

            long[][] childDp = dfs(child);

            long[] newNot = new long[k];
            long[] newTake = new long[k];

            for (int i = 0; i < k; i++) {

                for (int j = 0; j < k; j++) {

                    newNot[(i + j) % k] =
                        (newNot[(i + j) % k]
                        + notTake[i] * ((childDp[0][j] + childDp[1][j]) % MOD)) % MOD;

                    newTake[(i + j) % k] =
                        (newTake[(i + j) % k]
                        + take[i] * childDp[0][j]) % MOD;
                }
            }

            notTake = newNot;
            take = newTake;
        }

        return new long[][]{notTake, take};
    }
}
    