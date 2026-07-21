class Solution {
    int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    int n;

    public int swimInWater(int[][] grid) {
        n = grid.length;

        int low = grid[0][0];
        int high = n * n - 1;

        int res = 0;
        while (low <= high) {
            boolean[][] visited = new boolean[n][n];
            int mid = low + (high - low) / 2;

            if (isPossible(grid, visited, mid, 0, 0)) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return res;

    }

    public boolean isPossible(int[][] grid, boolean[][] visited, int mid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] > mid || visited[i][j])
            return false;
        visited[i][j] = true;
        if (i == n - 1 && j == n - 1)
            return true;

        for (int dir[] : dirs) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if (isPossible(grid, visited, mid, i_, j_))
                return true;

        }

        return false;

    }
}