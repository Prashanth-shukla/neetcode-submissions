class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        List<int[]> list = new ArrayList<>();
        int curri = newInterval[0];
        int currj = newInterval[1];
        int i = 0;

        for (; i < n; i++) {
            if (intervals[i][1] < newInterval[0]) {
                list.add(new int[] {intervals[i][0], intervals[i][1]});
                continue; // skip merge logic for non-overlapping "before" intervals
            }

            if (intervals[i][0] <= currj) {
                curri = Math.min(intervals[i][0], curri);
                currj = Math.max(intervals[i][1], currj);
            } else {
                break;
            }
        }
        list.add(new int[] {curri, currj});

        for (int x = i; x < n; x++) {
            list.add(new int[] {intervals[x][0], intervals[x][1]});
        }

        int[][] res = new int[list.size()][2];

        for (int x = 0; x < res.length; x++) {
            res[x][0] = list.get(x)[0];
            res[x][1] = list.get(x)[1];
        }

        return res;
    }
}