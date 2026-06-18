class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        q.add(root);
        //list.add(root.val);
        TreeNode right = null;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode rt = q.poll();

                if (rt != null)
                    right = rt;
                     if (rt.left != null)
                    q.add(rt.left);
                if (rt.right != null) {
                    q.add(rt.right);
                }

               
            }
            list.add(right.val);
        }

        return list;
    }
}
