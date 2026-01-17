class Solution {
    public List<String> generateParenthesis(int n) {
       
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String curr,
                           int open, int close, int n) {

        // Valid combination completed
        if (curr.length() == 2 * n) {
            result.add(curr);
            return;
        }

        // Add '(' if available
        if (open < n) {
            backtrack(result, curr + "(", open + 1, close, n);
        }

        // Add ')' if valid
        if (close < open) {
            backtrack(result, curr + ")", open, close + 1, n);
        }
    }
}

        
    