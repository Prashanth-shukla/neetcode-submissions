class Solution {
    int n, m;

    int[][] dp;

    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();

        dp = new int[n + 1][m + 1];

        for (int i[] : dp) Arrays.fill(i, -1);

        return solve(word1, word2, 0, 0);
    }

    public int solve(String word1, String word2, int i, int j) {
        if (i == n)
            return m - j;
        if (j == m)
            return n - i;

        if (dp[i][j] != -1)
            return dp[i][j];

        int insert = 0, delete = 0, replace = 0;

        if (word1.charAt(i) != word2.charAt(j)) {
            insert = 1 + solve(word1, word2, i, j + 1);
            delete = 1 + solve(word1, word2, i + 1, j);
            replace = 1 + solve(word1, word2, i + 1, j + 1);

            return dp[i][j] = Math.min(delete, Math.min(insert, replace));
        }

        return dp[i][j] = solve(word1, word2, i + 1, j + 1);
    }
}
