class Solution {
    int[][] dirs = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
    int m, n;

    public void solve(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 'O') {
                grid[0][j] = '#';
                q.add(new Pair(0, j));
            }

            if (grid[m - 1][j] == 'O') {
                grid[m - 1][j] = '#';
                q.add(new Pair(m - 1, j));
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 'O') {
                grid[i][0] = '#';
                q.add(new Pair(i, 0));

            }

            if (grid[i][n - 1] == 'O') {
                grid[i][n - 1] = '#';
                q.add(new Pair(i, n - 1));
            }

        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair p = q.poll();

                int i = p.i;
                int j = p.j;

                for (int[] dir : dirs) {
                    int i_ = i + dir[0];
                    int j_ = j + dir[1];

                    if (!isSafe(i_, j_))
                        continue;

                    if (grid[i_][j_] == 'O') {
                        grid[i_][j_] = '#';
                        q.add(new Pair(i_, j_));
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'O')
                    grid[i][j] = 'X';

                if (grid[i][j] == '#')
                    grid[i][j] = 'O';
            }
        }
    }

    public boolean isSafe(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

}

class Pair {
    int i, j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
