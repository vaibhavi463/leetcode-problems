class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] pos = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = arr[i][0];
            pos[arr[i][1]] = i;
        }
        int[] comp = new int[n];
        int cid = 0;
        comp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (values[i] - values[i - 1] > maxDiff)
                cid++;
            comp[i] = cid;
        }

        int[] far = new int[n];
        int r = 0;
        for (int i = 0; i < n; i++) {
            while (r + 1 < n && values[r + 1] - values[i] <= maxDiff)
                r++;
            far[i] = r;
        }

        int LOG = 18; 
        int[][] up = new int[LOG][n];

        for (int i = 0; i < n; i++)
            up[0][i] = far[i];

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {

            int u = pos[queries[qi][0]];
            int v = pos[queries[qi][1]];

            if (u == v) {
                ans[qi] = 0;
                continue;
            }

            if (comp[u] != comp[v]) {
                ans[qi] = -1;
                continue;
            }

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            int jumps = 0;
            int cur = u;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < v) {
                    cur = up[k][cur];
                    jumps += 1 << k;
                }
            }

            ans[qi] = jumps + 1;
        }

        return ans;
    }
}