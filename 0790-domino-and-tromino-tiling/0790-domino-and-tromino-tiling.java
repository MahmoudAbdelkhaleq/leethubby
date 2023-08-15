class Solution {
    int MOD = (int)Math.pow(10 , 9) + 7;
    public int numTilings(int n) {
        long [] dp = new long [n+1];
        Arrays.fill(dp, -1);
        return (int)solve(dp, n)%MOD;
    }
    private long solve(long [] dp, int n){
        if(n==0) return 1;
        if(n<3) return n;
        if(dp[n]!=-1) return dp[n];
        dp[n] = 2*solve(dp, n-1)%MOD+solve(dp,n-3)%MOD;
        return dp[n];
    }
}