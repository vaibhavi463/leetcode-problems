class Solution {
    public int maximum69Number (int num) {
        
        
        int temp = num;
        int pos = 1;
        int lastSixPos = 0;

        while (temp > 0) {
            int digit = temp % 10;

            if (digit == 6) {
                lastSixPos = pos;
            }

            temp /= 10;
            pos *= 10;
        }

        return lastSixPos == 0 ? num : num + 3 * lastSixPos;
    }
}

    