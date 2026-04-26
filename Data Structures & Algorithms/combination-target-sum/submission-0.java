class Solution {
    List<List<Integer>> global=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> temp=new ArrayList<>();
        backTrack(nums,target,temp,0);
        return global;

    }

    public void backTrack(int[] nums,int target,List<Integer> temp,int idx)
    {
        if(target==0)
        {
            global.add(new ArrayList(temp));
            return;

        }
         if(target<0)
        {
            return;
        }

        for(int i=idx;i<nums.length;i++)
        {
            temp.add(nums[i]);
         
             backTrack(nums,target-nums[i],temp,i);
           
             temp.remove(temp.size()-1);
        


        }
    }
}
