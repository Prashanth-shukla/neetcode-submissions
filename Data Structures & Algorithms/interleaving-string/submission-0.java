class Solution {
    int n, m, size;

    Boolean[][][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        n = s1.length();
        m = s2.length();
        size = s3.length();

        dp = new Boolean[n + 1][m + 1][size + 1];

        if (n + m != size)
            return false;

        return solve(s1, s2, s3, 0, 0, 0);
    }

    public boolean solve(String s1, String s2, String s3, int i, int j, int k) {
        if (i == n && j == m && k == size) {
            return true;
        }
        if (k >= size)
            return false;

        if (dp[i][j][k] != null)
            return dp[i][j][k];

        boolean withFirst = false, withSec = false;

        if (i < n && s1.charAt(i) == s3.charAt(k)) {
            withFirst = solve(s1, s2, s3, i + 1, j, k + 1);
        }

        if (withFirst)
            return true;

        if (j < m && s2.charAt(j) == s3.charAt(k)) {
            withSec = solve(s1, s2, s3, i, j + 1, k + 1);
        }

        if (withSec)
            return true;

        return dp[i][j][k] = withFirst || withSec;
    }
}