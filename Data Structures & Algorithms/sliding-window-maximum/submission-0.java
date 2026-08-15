class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.ele, a.ele));

//  PriorityQueue<Pair> maxPQ = new PriorityQueue<>((a, b) -> 
//  Integer.compare(b.first, a.first));

        int n = nums.length;
        int i = 0, j = 0;
        int idx=0;
        int[] ans=new int[n-k+1];
        while (j < n) {
            pq.add(new Pair(nums[j],j));

            while(!pq.isEmpty() && pq.peek().idx<i)
            {
                pq.poll();
            }

            if(j-i+1==k)
            {
                ans[idx++]=pq.peek().ele;
                i++;
            }
            j++;
        }
        return ans;
    }
}

class Pair {
    int ele, idx;

    Pair(int ele, int idx) {
        this.ele = ele;
        this.idx = idx;
    }
}
