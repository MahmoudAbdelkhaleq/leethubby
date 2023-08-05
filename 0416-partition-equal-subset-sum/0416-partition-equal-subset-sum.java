class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int target = total/2;
        if(total % 2 != 0) return false;

        Boolean dp[][] = new Boolean[nums.length + 1][target + 1];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i], null);
        }
        return memo(nums, 0, target, dp);
    }
    private boolean memo(int [] nums, int index, int target, Boolean [][] dp){
        if(index>=nums.length) return false;
        if(target<0) return false;
        if(target == 0) return true;
        if(dp[index][target]!=null) return dp[index][target];
        boolean p1 = memo(nums, index+1, target-nums[index], dp);
        boolean p2 = memo(nums, index+1, target, dp);
        dp[index][target] = p1 || p2;
        return dp[index][target];
    }
}