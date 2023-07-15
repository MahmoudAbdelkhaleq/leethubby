class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int [] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i< amount+1; i++){
            dp[i]= Integer.MAX_VALUE;
        }
        for(int i = 1; i< amount+1; i++){
            for(int j = 0;j<coins.length; j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    int subRes = 1 + dp[i-coins[j]];
                    if(subRes<dp[i]) dp[i] = subRes;
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}