/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
         if(root==null) return new ArrayList<>();
        q.add(root);

        while(!q.isEmpty())
        {
           
          List<Integer> list=new ArrayList<>();
         int size=q.size();
          //TreeNode curr=q.pop();

          for(int i=0;i<size;i++)
          {
            TreeNode rt=q.poll();
          
            if(rt.left!=null)
            q.add(rt.left);

             if(rt.right!=null)
            q.add(rt.right);
            list.add(rt.val);
          }
          ans.add(list);
         

           

        }
        return ans;
    }
}
