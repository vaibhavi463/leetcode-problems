class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }

                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] temp = q.poll();

                int r = temp[0];
                int c = temp[1];

                if (r + 1 < grid.length && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    fresh--;
                    q.add(new int[]{r + 1, c});
                }

                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    fresh--;
                    q.add(new int[]{r - 1, c});
                }

                if (c + 1 < grid[0].length && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    fresh--;
                    q.add(new int[]{r, c + 1});
                }

                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    fresh--;
                    q.add(new int[]{r, c - 1});
                }
            }

            time++;
        }

        if (fresh == 0) {
            return time;
        }

        return -1;
    }
}