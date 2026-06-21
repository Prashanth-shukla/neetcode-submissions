class Solution {
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        if(root.left==null && root.right==null)
        return root.val;

        solve(root);
        return maxSum;
    }

    public int solve(TreeNode root)
    {
        if(root==null) return 0;

        int left=Math.max(0,solve(root.left));
        int right=Math.max(0,solve(root.right));

        maxSum=Math.max(maxSum,root.val+left+right);

        return Math.max(left,right)+root.val;
    }
}
