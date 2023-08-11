class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int [coins.length][amount+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(amount, coins , dp, 0);
    }
    private int solve(int amount , int [] coins, int [][] dp, int index){
        if(amount == 0) return 1;
        if(index==coins.length)return 0;
        if(dp[index][amount]!=-1) return dp[index][amount];
        if(coins[index]>amount){
            dp[index][amount] = solve(amount, coins, dp, index+1);
            return dp[index][amount];
        }
        dp[index][amount] = solve(amount-coins[index], coins, dp, index) + solve(amount, coins, dp, index+1);
        return dp[index][amount];
    }
}