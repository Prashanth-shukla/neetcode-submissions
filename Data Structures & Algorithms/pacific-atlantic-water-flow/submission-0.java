class Solution {
    int[][] dirs = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
    List<List<Integer>> list = new ArrayList<>();
    int n, m;

    public List<List<Integer>> pacificAtlantic(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        boolean[][] pacific = new boolean[m][n];

        boolean[][] atlantic = new boolean[m][n];

        for (int j = 0; j < n; j++)
            DFS(grid, 0, j, pacific);

        for (int i = 0; i < m; i++)
            DFS(grid, i, 0, pacific);

        for (int j = 0; j < n; j++)
            DFS(grid, m - 1, j, atlantic);

        for (int i = 0; i < m; i++)
            DFS(grid, i, n - 1, atlantic);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    list.add(Arrays.asList(i, j));
                }
            }
        }

        return list;

    }

    public void DFS(int[][] grid, int i, int j, boolean[][] visited) {
        if (visited[i][j])
            return;
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if (!safe(i_, j_) || grid[i][j] > grid[i_][j_]) {
                continue;
            }

            DFS(grid, i_, j_, visited);
        }
    }

    public boolean safe(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}