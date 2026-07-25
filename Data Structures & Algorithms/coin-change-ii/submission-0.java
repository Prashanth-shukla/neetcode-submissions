class Solution {
    int n;
    int[][] dp;
    public int change(int amount, int[] coins) {
        n = coins.length;

        dp=new int[n][amount+1];

        for(int i[]:dp)
        Arrays.fill(i,-1);

        return solve(amount, coins, 0, 0);
    }

    public int solve(int amount, int[] coins, int idx, int sum) {
        if (sum == amount)
            return 1;

        else if (sum > amount)
            return 0;

        if (idx >= n)
            return 0;

        if(dp[idx][sum]!=-1)
        return dp[idx][sum];

        int take = 0, skip = 0;

        take = solve(amount, coins, idx, sum + coins[idx]);
        skip = solve(amount, coins, idx + 1, sum);

        return dp[idx][sum]=take + skip;
    }
}
