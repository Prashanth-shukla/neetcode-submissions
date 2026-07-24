class Solution {
    int n;
    int offset;

    int[][] dp;

    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        int total = 0;
        for (int num : nums)
            total += num;

        if (target > total || target < -total)
            return 0;

        offset = total;
        dp = new int[n][2 * total + 1];

        for (int[] i : dp)
            Arrays.fill(i, -1);

        return solve(nums, 0, target, 0);

    }

    public int solve(int[] nums, int sum, int target, int idx) {

        if (idx == n) {
            if (sum == target)
                return 1;
            return 0;
        }
        if (dp[idx][sum + offset] != -1)
            return dp[idx][sum + offset];

        int usingAdditon = solve(nums, sum + nums[idx], target, idx + 1);
        int usingSubtraction = solve(nums, sum - nums[idx], target, idx + 1);

        return dp[idx][sum + offset] = usingAdditon + usingSubtraction;

    }
}