class Solution {
    int max = 0;
    int n, m;
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        if (n == 1 && m == 1) {
            if (grid[0][0] == 1)
                return 1;
                else return 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {

                    max = Math.max(max,   DFS(i, j, visited, grid));
                  
                  
                }
            }
        }

        return max;
    }

    public boolean isSafe(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public int DFS(int i, int j, boolean[][] visited, int[][] grid) {
        visited[i][j] = true;
        int area=1;

        for (int[] dir : dirs) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            if (!isSafe(i_, j_))
                continue;

            if (!visited[i_][j_] && grid[i_][j_] == 1) {
                count++;
                area+=DFS(i_, j_, visited, grid);
            }
        }
        return area;
    }
}
