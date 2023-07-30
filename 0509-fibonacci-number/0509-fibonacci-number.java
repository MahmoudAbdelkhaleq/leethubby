class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        int [] dp = new int [n+1];
        dp[0] = 0;
        dp[1] = 1;
        return calc(n,dp);
    }
    private int calc(int n, int [] dp){
        if(n<=0) return 0;
        if(dp[n]!=0) return dp[n];
        dp[n] = calc(n-1, dp)+calc(n-2, dp);
        return dp[n];
    }
}