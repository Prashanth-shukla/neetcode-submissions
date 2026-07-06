class Solution {
    int n, m;
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int fresh = 0;

        if (n == 1 && m == 1) {
            if (grid[0][0] == 0 || grid[0][0] == 2)
                return 0;
            if (grid[0][0] == 1)
                return -1;
        }

        boolean[][] visited = new boolean[n][m];

        int level = 0;

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j));
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        if(fresh==0) return 0;

        while (fresh>0&&!q.isEmpty()) {
            int size = q.size();
           
            while (size-- > 0) {
                Pair p = q.poll();
                int curri = p.i;
                int currj = p.j;

                for (int[] dir : dirs) {
                    int i_ = curri + dir[0];
                    int j_ = currj + dir[1];

                    if (!isSafe(i_, j_) || visited[i_][j_] || grid[i_][j_] != 1)
                        continue;

                    visited[i_][j_] = true;

                    grid[i_][j_] = 2;
                    fresh--;

                    q.add(new Pair(i_, j_));
                }
            }
             level++;
        }

        if (fresh == 0)
            return level;

        return -1;
    }

    public boolean isSafe(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}

class Pair {
    int i, j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
