class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxdst = 0;
        for(int i = 0;i< n; i++){
            if(i> maxdst){
                return false;
            }
            maxdst = Math.max(maxdst,nums[i]+i);
        }
        return true;
        
    }
}