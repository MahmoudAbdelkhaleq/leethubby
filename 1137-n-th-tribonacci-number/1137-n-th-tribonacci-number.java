class Solution {
    public int tribonacci(int n) {
        int [] dp = new int [n+1];
        return calc(n, dp);
    }
    private int calc(int n, int [] dp){
        if(n<=0) return 0;
        if(n==2) return 1;
        if(n==1) return 1;
        if(dp[n]!=0)return dp[n];
        dp[n] = calc(n-1, dp)+ calc(n-2, dp)+ calc(n-3, dp);
        return dp[n];
    }
}