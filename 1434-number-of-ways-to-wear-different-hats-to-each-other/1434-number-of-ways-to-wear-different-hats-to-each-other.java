

class Solution {

    static final int MOD = 1000000007;

    public int numberWays(List<List<Integer>> hats) {
        
        int n = hats.size();
        
        List<Integer>[] hatToPeople = new ArrayList[41];
        for (int i = 0; i <= 40; i++) {
            hatToPeople[i] = new ArrayList<>();
        }
        
        for (int person = 0; person < n; person++) {
            for (int hat : hats.get(person)) {
                hatToPeople[hat].add(person);
            }
        }
        
        int size = 1 << n;
        int[] dp = new int[size];
        dp[0] = 1;
        
        for (int hat = 1; hat <= 40; hat++) {
            
            int[] newDp = dp.clone();
            
            for (int mask = 0; mask < size; mask++) {
                
                if (dp[mask] == 0) continue;
                
                for (int person : hatToPeople[hat]) {
                    
                    if ((mask & (1 << person)) == 0) {
                        int newMask = mask | (1 << person);
                        newDp[newMask] = (newDp[newMask] + dp[mask]) % MOD;
                    }
                }
            }
            
            dp = newDp;
        }
        
        return dp[size - 1];
    }
}