class Solution {
    int dp[][] = new int[301][301];

    public int maxCoins(int[] nums) {
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j <= 300; j++) {
                dp[i][j] = -1;
            }
        }
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i : nums)
            list.add(i);
        list.add(1);

        return solve(list, 1, n);
    }

    private int solve(List<Integer> list, int i, int j) {

        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int max = Integer.MIN_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int cost = list.get(i - 1) * list.get(ind) * list.get(j + 1) + solve(list, i, ind - 1)
                    + solve(list, ind + 1, j);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;

    }
}