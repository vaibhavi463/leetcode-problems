
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] best = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(best[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        int startCost = grid.get(0).get(0);
        best[0][0] = startCost;
        pq.offer(new int[]{0, 0, startCost});

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], cost = cur[2];

            if (cost != best[r][c]) continue;

            if (r == m - 1 && c == n - 1) {
                return cost < health;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newCost = cost + grid.get(nr).get(nc);
                    if (newCost < best[nr][nc]) {
                        best[nr][nc] = newCost;
                        pq.offer(new int[]{nr, nc, newCost});
                    }
                }
            }
        }

        return false;
    }
}