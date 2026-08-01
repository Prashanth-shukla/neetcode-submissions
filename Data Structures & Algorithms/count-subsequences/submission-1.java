class Solution {
    int n, m;
    int[][] dp;

    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();

        dp = new int[n + 1][m + 1];

        for (int[] i : dp) Arrays.fill(i, -1);

        return solve(s, t, 0, 0);
    }

    public int solve(String s, String t, int i, int j) {
        if (j == m) {
            return 1;
        }

        else if (i == n)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int take = 0, skip = 0;

        if (s.charAt(i) == t.charAt(j)) {
            take += solve(s, t, i + 1, j + 1);
        }
        skip += solve(s, t, i + 1, j);

        return dp[i][j] = take + skip;
    }
}