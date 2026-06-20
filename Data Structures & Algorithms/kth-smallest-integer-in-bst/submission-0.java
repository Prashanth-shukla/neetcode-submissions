class Solution {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root,k);
        return list.get(k - 1);
    }

    public void inOrderTraversal(TreeNode root, int k) {
        if (root == null)
            return ;

        inOrderTraversal(root.left, k);
        list.add(root.val);
        inOrderTraversal(root.right, k);
    }
}
