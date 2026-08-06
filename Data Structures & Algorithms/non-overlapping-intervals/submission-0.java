class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int i = 1, count = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prevj = intervals[0][1];
        while (i < n) {
            if (prevj > intervals[i][0]) {
                count++;
            } else {
                prevj = intervals[i][1];
            }
            i++;
        }

        return count;
    }
}