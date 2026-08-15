class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int max=Integer.MIN_VALUE;
        if(n==0) return 0;
        Map<Character, Integer> mp = new HashMap<>();

        while (j < n) {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            while (mp.get(ch) > 1) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                if (mp.get(s.charAt(i)) == 0)
                    mp.remove(s.charAt(i));
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}
