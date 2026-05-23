class Solution {
    public int minimumSwaps(int[] nums) {
       
        int zeros = 0;
        for(int x:nums){
            if(x==0){
                zeros++;
            }
        }
        int already = 0;
        for(int i = nums.length-zeros;i<nums.length;i++){
            if(nums[i] == 0){
                already++;
            }
        }
        return zeros- already;
    }
}