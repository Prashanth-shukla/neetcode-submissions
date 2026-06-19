class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int max = root.val;
        return 1 + countNodes(root, max);
    }

    public int countNodes(TreeNode root, int max) {
        if (root == null) return 0;

        int leftCount = 0, rightCount = 0;

        if (root.left != null) {
            if (root.left.val >= max) {
                leftCount = 1 + countNodes(root.left, root.left.val);
            } else {
                leftCount = countNodes(root.left, max);
            }
        }

        if (root.right != null) {
            if (root.right.val >= max) {
                rightCount = 1 + countNodes(root.right, root.right.val);
            } else {
                rightCount = countNodes(root.right, max);
            }
        }

        return leftCount + rightCount;   // combine both, don't return early
    }
}