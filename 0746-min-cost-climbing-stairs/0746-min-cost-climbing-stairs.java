class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp =new int[cost.length+1];
        return calc(cost, dp, cost.length);
    }
    private int calc(int [] cost, int [] dp, int n){
        if(n==0 || n == 1) return 0;
        if(dp[n]!=0) return dp[n];
        dp[n] = Math.min(calc(cost, dp, n-1)+cost[n-1], calc(cost, dp, n-2)+cost[n-2]);
        return dp[n];
    }
}