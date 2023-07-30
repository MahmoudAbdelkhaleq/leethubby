class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        Arrays.fill(dp, -1);
        return calc(nums.length-1, nums, dp);
    }
    private int calc(int n, int [] nums, int [] dp){
        if(n==0) return nums[0];
        if(n==1) return Math.max(nums[0], nums[1]);
        if(dp[n]!=-1) return dp[n];
        dp[n] = Math.max(calc(n-1, nums, dp), calc(n-2, nums, dp) + nums[n]);
        return dp[n];
    }
}