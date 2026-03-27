class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (int j= 0; j < s.length(); j++) {
            while (charSet.contains(s.charAt(j))) {
                charSet.remove(s.charAt(i));
                i++;
            }

            charSet.add(s.charAt(j));
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;       
    }
}
        
    