class Solution {
    List<List<Integer>> global=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(nums);
        solve(0,curr,nums);
        return global;
    }

    public void solve(int idx,List<Integer> curr,int[] nums)
    {
        if(curr.size()>=0)
        {
            global.add(new ArrayList(curr));

        }

        for(int i=idx;i<nums.length;i++)
        {
            if(i>idx && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            solve(i+1,curr,nums);
            curr.remove(curr.size()-1);
        }
    }
}
