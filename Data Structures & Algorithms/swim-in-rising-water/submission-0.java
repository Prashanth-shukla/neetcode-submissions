class Solution {
    int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    int n;

    public boolean isSafe(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    public int swimInWater(int[][] grid) {
        n = grid.length;

        int ans[][] = new int[n][n];

        for (int i[] : ans)
            Arrays.fill(i, Integer.MAX_VALUE);
        ans[0][0] = grid[0][0];

        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        pq.add(new int[] { 0, 0, grid[0][0] });

        while (!pq.isEmpty()) {
            int[] p = pq.poll();

            int i = p[0];
            int j = p[1];
            int level = p[2];

            if (visited[i][j])
                continue;

            if (i == n - 1 && j == n - 1)
                return level;
            visited[i][j] = true;

            for (int[] dir : dirs) {
                int i_ = i + dir[0];
                int j_ = j + dir[1];

                if (!isSafe(i_, j_) || visited[i_][j_])
                    continue;

                int currLvl = grid[i_][j_];

                int abs = Math.abs(grid[i][j] - grid[i_][j_]);
                int max = Math.max(level, grid[i_][j_]);

                if (ans[i_][j_] > max) {
                    ans[i_][j_] = max;
                    pq.add(new int[] { i_, j_, max });

                }

            }
        }

        return ans[n - 1][n - 1];

    }
}