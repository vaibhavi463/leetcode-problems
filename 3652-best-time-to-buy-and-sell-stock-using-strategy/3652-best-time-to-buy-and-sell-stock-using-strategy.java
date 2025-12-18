class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        // Step 1: base profit
        long base = 0;
        for (int i = 0; i < n; i++) {
            base += (long) prices[i] * strategy[i];
        }

        // Step 2: build gain arrays
        long[] holdGain = new long[n];
        long[] sellGain = new long[n];

        for (int i = 0; i < n; i++) {
            holdGain[i] = -(long) strategy[i] * prices[i];
            sellGain[i] = (long) prices[i] * (1 - strategy[i]);
        }

        // Step 3: sliding window
        long maxGain = 0;
        long curGain = 0;

        // initial window
        for (int i = 0; i < k / 2; i++) {
            curGain += holdGain[i];
        }
        for (int i = k / 2; i < k; i++) {
            curGain += sellGain[i];
        }

        maxGain = Math.max(maxGain, curGain);

        // slide window
        for (int l = 1; l + k - 1 < n; l++) {
            int outHold = l - 1;
            int inHold = l + k / 2 - 1;
            int outSell = l + k / 2 - 1;
            int inSell = l + k - 1;

            curGain -= holdGain[outHold];
            curGain += holdGain[inHold];

            curGain -= sellGain[outSell];
            curGain += sellGain[inSell];

            maxGain = Math.max(maxGain, curGain);
        }

        return base + maxGain;
    }
}
