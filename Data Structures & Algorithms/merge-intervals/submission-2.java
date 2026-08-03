class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 1)
            return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> list = new ArrayList<>();

        int i = 1;
        int curri = intervals[i - 1][0];
        int currj = intervals[i - 1][1];

        
      

        while (i < n) {
            if (currj >= intervals[i][0]) {
                curri = Math.min(curri, intervals[i][0]);
                currj = Math.max(currj, intervals[i][1]);

            } else{
                  list.add(new int[] {curri, currj});
                curri = intervals[i][0];
                currj = intervals[i][1];

            }
            i++;
               
        }
        list.add(new int[] {curri, currj});

          return list.toArray(new int[list.size()][]); 
    }
}
