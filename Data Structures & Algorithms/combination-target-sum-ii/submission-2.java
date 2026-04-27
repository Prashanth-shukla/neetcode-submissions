class Solution {
       List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target)
    {
        Arrays.sort(nums);
        List<Integer> curr=new ArrayList<>();
       backTrack(curr,0,nums,target);
       return list; 
    }

    public void backTrack( List<Integer> curr,int idx,int[] nums,int target)
    {
        if(target==0)
        {
            list.add(new ArrayList(curr));
            return;
        }
        if(target<0)
        return;

        for(int i=idx;i<nums.length&&target>=nums[i];i++)
        {
            if(i>idx&&nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            backTrack(curr,i+1,nums,target-nums[i]);
            curr.remove(curr.size()-1);
        }
    }
}
