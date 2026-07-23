class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        dp=new int[n+1][m+1];

        for(int[] i:dp)
        Arrays.fill(i,-1);

        return solve(text1, text2, 0, 0);
    }

    public int solve(String str1, String str2, int i, int j) {
        if (i == str1.length() || j == str2.length())
            return 0;

            if(dp[i][j]!=-1) return dp[i][j];

        if (str1.charAt(i) == str2.charAt(j))
            return dp[i][j]=1 + solve(str1, str2, i + 1, j + 1);

        else {
            return dp[i][j]=Math.max(solve(str1, str2, i + 1, j), solve(str1, str2, i, j + 1));
        }
    }
}
