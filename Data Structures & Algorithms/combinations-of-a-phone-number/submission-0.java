class Solution {
    int idx1 = 0;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
         List<String> list = new ArrayList<>();
         if (n == 0)
            return  list;

       

        Map<Character, String> mp = new HashMap<>();

        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        backTrack(mp, digits, 0, list, sb);

        return list;

    }

    public void backTrack(Map<Character, String> mp, String digits, int idx, List<String> list, StringBuilder sb) {
        int n = digits.length();
        if (idx >= n) {
            // idx1++;

            list.add(sb.toString());
            return;

        }

        char ch = digits.charAt(idx);
        String str = mp.get(ch);
        int size = str.length();

        for (char ch1 : str.toCharArray()) {
            sb.append(String.valueOf(ch1));
            backTrack(mp, digits, idx + 1, list, sb);

            sb.deleteCharAt(sb.length() - 1);
        }

    }
}