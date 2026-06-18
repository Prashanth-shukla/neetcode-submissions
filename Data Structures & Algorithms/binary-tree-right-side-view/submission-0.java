

class Solution {
    public List<Integer> rightSideView(TreeNode root)
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
           if(rt.right!=null)
            q.add(rt.right);
            if(rt.left!=null)
            q.add(rt.left);

            
            list.add(rt.val);
          }
          ans.add(list);
         

           

        }
        List<Integer> l=new ArrayList<>();

        for(List<Integer> list:ans)
        {
            if(!list.isEmpty())
            l.add(list.get(0));
        }
        return l;
    }
}
