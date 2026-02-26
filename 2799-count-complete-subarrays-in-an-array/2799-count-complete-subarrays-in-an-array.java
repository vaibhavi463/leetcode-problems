class Solution {
    public int countCompleteSubarrays(int[] nums) {
       


        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int totalDistinct = set.size();

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

          
            while (map.size() == totalDistinct) {
                ans += nums.length - right;

                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
        }
        return ans;
    }
}

        
    