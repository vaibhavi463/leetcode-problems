import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        solve(nums, 0, curr, res);
        return res;
    }

    void solve(int[] arr, int i, List<Integer> curr, List<List<Integer>> res) {

        // BASE CASE
        if (i == arr.length) {
            res.add(new ArrayList<>(curr)); // store copy
            return;
        }

        // TAKE
        curr.add(arr[i]);
        solve(arr, i + 1, curr, res);

        // BACKTRACK
        curr.remove(curr.size() - 1);

        // NOT TAKE
        solve(arr, i + 1, curr, res);
    }
}