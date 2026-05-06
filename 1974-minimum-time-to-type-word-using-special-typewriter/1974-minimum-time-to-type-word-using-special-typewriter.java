class Solution {
    public int minTimeToType(String word) {
        int time  = 0;
        int curr = 0;
        for(int i = 0;i<word.length();i++){
            int next = word.charAt(i) - 'a';
            int diff = Math.abs(curr - next);
            time += Math.min(diff,26-diff) +1;
            curr = next;

        }
        return time;
    }
}   