class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (Interval i : intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end, map.getOrDefault(i.end, 0) - 1);
        }

        int overlap = 0;
        int maxoverlap = 0;

        for (int delta : map.values()) {
            overlap += delta;
            maxoverlap = Math.max(maxoverlap, overlap);
        }

        return maxoverlap;
    }
}