class Solution {
    // public int combinationSum4(int[] nums, int target) {
    //     Arrays.sort(nums);
    //     int [][] dp = new int [nums.length][target+1];
    //     for(int i=0;i<dp.length;i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     return solve(nums, target, dp, 0);
    // }
    // private int solve(int [] nums, int target, int [][] dp, int index){
    //     if(target<0) return 0;
    //     if(target == 0) return 1;
    //     if(index >= nums.length || index < 0 ) return 0;
    //     if(dp[index][target]!=-1)return dp[index][target];
    //     dp[index][target] = solve(nums, target, dp, index+1) + solve(nums, target-nums[index], dp, index)
    //         +solve(nums, target-nums[index], dp, index-1);
    //     return dp[index][target];
    // }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (n <= i) {
                    dp[i] += dp[i - n];
                }
            }
        }

        return dp[target];        
    }
}