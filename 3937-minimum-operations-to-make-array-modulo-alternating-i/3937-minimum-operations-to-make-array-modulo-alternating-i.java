class Solution {
    public int minOperations(int[] nums, int k) {
        
        int [] velmorqati = nums;
        int ans= Integer.MAX_VALUE;
        for(int x = 0;x<k;x++){
            for(int y = 0;y<k;y++){
                if(x == y){
                    continue;
                }
                int cost = 0;
                for(int i = 0;i<nums.length;i++){
                    int target;
                    if(i % 2 == 0){
                        target = x;
                        
                    }
                    else{
                        target = y;
                    }
                    int rem = nums[i]%k;
                    int diff = Math.abs(rem-target);
                    cost+= Math.min(diff,k-diff);
                    
                }
                ans= Math.min(ans,cost);
            }
        }
        return ans;
        
    }
}