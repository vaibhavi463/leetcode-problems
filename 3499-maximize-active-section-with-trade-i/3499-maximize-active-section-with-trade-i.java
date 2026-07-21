class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int active = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') active++;
        }

        String t = "1" + s + "1";

        ArrayList<Character> type = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();

        int i = 0;
        while (i < t.length()) {
            char ch = t.charAt(i);
            int j = i;
            while (j < t.length() && t.charAt(j) == ch) {
                j++;
            }
            type.add(ch);
            len.add(j - i);
            i = j;
        }

        int ans = active;

        for (i = 1; i < type.size() - 1; i++) {
            if (type.get(i) == '1' &&
                type.get(i - 1) == '0' &&
                type.get(i + 1) == '0') {

                ans = Math.max(ans, active + len.get(i - 1) + len.get(i + 1));
            }
        }

        return ans;
    }
}