class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[n + 2][2];
        // dp[idx][holding]

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int holding = 0; holding <= 1; holding++) {
                int cool = dp[idx + 1][holding];
                int take;

                if (holding == 0) {
                    take = -prices[idx] + dp[idx + 1][1];
                } else {
                    take = prices[idx] + dp[idx + 2][0];
                }

                dp[idx][holding] = Math.max(cool, take);
            }
        }

        return dp[0][0];
    }
}