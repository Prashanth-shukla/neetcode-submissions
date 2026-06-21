class Solution {
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 1)
            return new TreeNode(preorder[0]);

        return solve(0, n - 1, preorder, inorder);
        // root;
    }

    public TreeNode solve(int start, int lim, int[] preorder, int[] inorder) {
        if (start > lim)
            return null;

        int rtIdx = -1;

        int rtVal = preorder[idx++];
        int i = start;
         for (; i <= lim; i++) {
            if (inorder[i] == rtVal) {
                break;
            }
        }

        TreeNode root = new TreeNode(rtVal);
        root.left = solve(start, i - 1, preorder, inorder);

        root.right = solve(i + 1, lim, preorder, inorder);

        return root;
    }
}
