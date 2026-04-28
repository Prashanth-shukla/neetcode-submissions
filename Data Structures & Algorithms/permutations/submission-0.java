class Solution {
    List<List<Integer>> global=new ArrayList<>();
    Set<Integer> st=new HashSet<>();
    public List<List<Integer>> permute(int[] nums)
    {
        List<Integer> curr=new ArrayList<>();
        solve(nums,curr);
        return global;
    }

    public void solve(int[] nums,List<Integer> curr)
    {
        if(curr.size()==nums.length)
        {
            global.add(new ArrayList(curr));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
        if(st.contains(nums[i])) continue;
        curr.add(nums[i]);
        st.add(nums[i]);
        solve(nums,curr);
        curr.remove(curr.size()-1);
        st.remove(nums[i]);

        }

      
    }
}
