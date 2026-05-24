class Solution {
    public int minEatingSpeed(int[] piles, int h)
    {
        int n=piles.length;
        Arrays.sort(piles);
        int min=1;
        int max=piles[n-1];

        while(min<=max)
        {
            int mid=min+(max-min)/2;
            if(isPossible(piles,h,mid))
            {
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }

        return min;
    }



    public boolean isPossible(int[] nums,int h ,int mid)
    {
        int count=0;
        for(int i:nums)
        {
        count+=(i+mid-1)/mid;
        }
        return count<=h;
    }
}
