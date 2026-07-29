class Solution {
    private final long MAX = 1_000_001L;

    public String smallestPalindrome(String s, int k) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int[] halfCount = new int[26];
        char midLetter = 0;

        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
            if ((count[i] & 1) == 1) {
                midLetter = (char) ('a' + i);
            }
        }

        long totalPerm = countArrangements(halfCount);

        if (k > totalPerm) {
            return "";
        }

        int halfLen = 0;
        for (int x : halfCount) {
            halfLen += x;
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int i = 0; i < 26; i++) {
                if (halfCount[i] == 0) {
                    continue;
                }

                halfCount[i]--;

                long ways = countArrangements(halfCount);

                if (ways >= k) {
                    left.append((char) ('a' + i));
                    break;
                } else {
                    k -= ways;
                    halfCount[i]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);

        if (midLetter != 0) {
            ans.append(midLetter);
        }

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long countArrangements(int[] count) {
        int total = 0;

        for (int x : count) {
            total += x;
        }

        long res = 1;

        for (int freq : count) {
            res *= nCk(total, freq);

            if (res >= MAX) {
                return MAX;
            }

            total -= freq;
        }

        return res;
    }

    private long nCk(int n, int k) {
        k = Math.min(k, n - k);

        long res = 1;

        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;

            if (res >= MAX) {
                return MAX;
            }
        }

        return res;
    }
}