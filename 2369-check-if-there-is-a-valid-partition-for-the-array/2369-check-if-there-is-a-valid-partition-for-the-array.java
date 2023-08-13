class Solution {
    public boolean validPartition(int[] nums) {
        Boolean [] dp = new Boolean[nums.length];
        dp[0]= false;
        return solve(nums, dp, nums.length-1);
    }
    private boolean solve(int [] nums, Boolean [] dp, int index){
        if(index<0)return true;
        if(index == 1){
            if(nums[1]==nums[0]){
                dp[1] = true;
            }
            else dp[1] = false;
            return dp[1];
        }
        if(dp[index]!=null) return dp[index];
        dp[index] = (nums[index]==nums[index-1] && solve(nums,dp,index-2)) ||
                    (nums[index]==nums[index-1] && nums[index] == nums[index-2] && solve(nums,dp,index-3)) ||
                    (nums[index]==nums[index-1]+1 && nums[index] == nums[index-2]+2 && solve(nums,dp,index-3));
        return dp[index];
    }
}