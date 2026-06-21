
class Solution {
    int whole = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null)
            return root.val;
        solve(root);
        return whole;
    }

    public int solve(TreeNode root) {
        if (root == null)
            return 0;

        int left = solve(root.left);

        int right = solve(root.right);

        int neeche_hi_ans_mil_gya = left + right + root.val;

        int koi_ek_accha = Math.max(left, right) + root.val;

        int sirf_root_accha = root.val;

        whole = Math.max(Math.max(neeche_hi_ans_mil_gya, whole), Math.max(koi_ek_accha, sirf_root_accha));

        return Math.max(koi_ek_accha, sirf_root_accha);
    }
}