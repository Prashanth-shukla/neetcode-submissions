class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
   
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    q.add(new Pair(i, j));
            }
        }

        boolean[][] visited = new boolean[n][m];
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Pair p = q.poll();
                int i = p.i;
                int j = p.j;
              

                for (int[] dir : dirs) {
                    int i_ = i + dir[0];
                    int j_ = j + dir[1];
                    

                    if (!isSafe(i_, j_, grid,n,m) || visited[i_][j_])
                        continue;
                         visited[i_][j_] = true;
                    if(grid[i_][j_]!=0)
                    grid[i_][j_] = level;
                    q.add(new Pair(i_, j_));
                }
            }

            level++;
        }
    }

    public boolean isSafe(int i, int j, int[][] grid,int n,int m) {
        return i >= 0 && i < n && j >= 0 && j < m && grid[i][j] != -1;
    }
}

class Pair {
    int i, j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
