/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> list = new ArrayList<>();

        for (Interval i : intervals) {
            int start = i.start;
            int end = i.end;

            list.add(new int[] {start, 1});
            list.add(new int[] {end, -1});
        }

  list.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int overlap = 0;
        int maxoverlap = 0;

        for (int[] i : list) {
            overlap += i[1];
            if (maxoverlap < overlap) {
                maxoverlap = overlap;
            }
        }
        return maxoverlap;
    }
}
