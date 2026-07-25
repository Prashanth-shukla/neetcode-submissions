class Solution {
    int n;
    int profit = 0;

    int[][] dp;
    public int maxProfit(int[] prices) {
        n = prices.length;

        dp=new int[n][2];

        for(int[] i:dp)
        Arrays.fill(i,-1);

        return solve(prices, 0, 0);
    }

    public int solve(int[] prices, int idx, int holding) {
        if (idx >= n)
            return 0;

            if(dp[idx][holding]!=-1)
            return dp[idx][holding];


        int take = 0, cool = 0;

        cool = solve(prices, idx + 1, holding);

        if (holding == 0) {
            take = -prices[idx] + solve(prices, idx + 1, 1);
        } else
            take = prices[idx] + solve(prices, idx + 2, 0);

        return dp[idx][holding]=Math.max(cool, take);
    }
}
