class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        int max = root.val;

        return 1 + countNodes(root, max);
    }

    public int countNodes(TreeNode root, int max) {
        if (root == null)
            return 0;
            int left=0,right=0;

        if (root.left != null) {
            if (root.left.val >= max) {
                left= 1 + countNodes(root.left, root.left.val);

            } else {
                left= countNodes(root.left, max);
            }
        }

        if (root.right != null) {
            if (root.right.val >= max) {
                right= 1 + countNodes(root.right, root.right.val);

            } else {
                right= countNodes(root.right, max);
            }
        }

        return left+right;
    }
}
