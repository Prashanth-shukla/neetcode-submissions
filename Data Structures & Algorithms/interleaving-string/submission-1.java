class Solution {
    int n, m, size;

    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        n = s1.length();
        m = s2.length();
        size = s3.length();

        dp = new Boolean[n + 1][m + 1];

        if (n + m != size)
            return false;

        return solve(s1, s2, s3, 0, 0);
    }

    public boolean solve(String s1, String s2, String s3,
            int i, int j) {
        if (i == n && j == m ) {
            return true;
        }
        if ((i+j) >= size)
            return false;

        if (dp[i][j] != null)
            return dp[i][j];

        boolean withFirst = false, withSec = false;

        if (i < n && s1.charAt(i) == s3.charAt(i+j)) {

            withFirst = solve(s1, s2, s3, i + 1, j);

        }

        if (withFirst)
            return true;

        if (j < m && s2.charAt(j) == s3.charAt(i+j)) {

            withSec = solve(s1, s2, s3, i, j + 1);

        }

        if (withSec)
            return true;

        return dp[i][j] = withFirst || withSec;

    }
}