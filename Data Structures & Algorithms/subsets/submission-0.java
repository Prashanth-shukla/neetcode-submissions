class Solution {
    List<List<Integer>> global=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) 
    {
        int n=nums.length;
        List<Integer> curr=new ArrayList<>();

         backTrack(curr,nums,0);
         return global;
    }

    public void backTrack( List<Integer> temp,int[] nums,int idx)
    {
        if(idx==nums.length)
        {
            global.add(new ArrayList(temp));
            return;
        }

        temp.add(nums[idx]);
        backTrack(temp,nums,idx+1);
        temp.remove(temp.size()-1);
        backTrack(temp,nums,idx+1);


    }
}
