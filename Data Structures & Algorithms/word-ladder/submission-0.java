class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> mp = new HashMap<>();
        int count = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.count, b.count));

        for (String str : wordList)
            mp.put(str, Integer.MAX_VALUE);
        mp.put(beginWord, 1);
        pq.add(new Pair(beginWord, mp.get(beginWord)));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            String currStr = p.str;
            int currCount = p.count;

            if (currStr.equals(endWord))
                return currCount;

            for (String str : wordList) {

                if (isPossible(currStr, str)) {

                    int nextCount = currCount + 1;

                    if (mp.get(str) > nextCount) {
                        mp.put(str, nextCount);
                        pq.add(new Pair(str, nextCount));
                    }

                }
            }

        }

        if (!mp.containsKey(endWord))
            return 0;

        return mp.get(endWord) == Integer.MAX_VALUE ? 0 : mp.get(endWord);

    }

    public boolean isPossible(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int n = str1.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt(i))
                count++;

            if (count > 1)
                return false;

        }

        return count == 1;
    }
}

class Pair {
    String str;
    int count;

    Pair(String str, int count) {
        this.str = str;
        this.count = count;
    }
}