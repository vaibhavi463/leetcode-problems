class Solution {
    public boolean isMatch(String s, String p) {
       
        int n = s.length();
        int m = p.length();
        
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Handle cases where pattern starts with '*'
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    // '*' matches empty sequence or one/more characters
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    // Current characters match
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[n][m];
    }
}
