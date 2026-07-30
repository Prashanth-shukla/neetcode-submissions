class Solution {
    int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    int n, m;

    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int max = -1;

        dp = new int[n + 1][m + 1];

        for (int i[] : dp)
            Arrays.fill(i, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                max = Math.max(max, DFS(matrix, i, j));
            }
        }

        return max;

    }

    public int DFS(int[][] mat, int i, int j) {

        if (dp[i][j] != -1)
            return dp[i][j];
        int length = 1;

        for (int[] dir : dirs) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if (!isSafe(i_, j_))
                continue;

            if (mat[i_][j_] > mat[i][j]) {
                length =Math.max(length, 1 + DFS(mat, i_, j_));
            }
        }

        return dp[i][j] = length;

    }

    public boolean isSafe(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}