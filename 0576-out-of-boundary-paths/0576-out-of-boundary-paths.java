class Solution {
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int [] [] [] dp = new int [m][n][maxMove+1];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(m, n, maxMove, startRow, startColumn, dp);
    }
    private int solve(int m, int n, int moves, int i, int j, int [][][] dp){
        if(i<0||j<0||i==m||j==n) return 1;
        if(moves == 0) return 0;
        if(dp[i][j][moves]!=-1) return dp[i][j][moves];
        dp[i][j][moves] = (((solve(m,n,moves-1,i+1,j,dp) + solve(m,n,moves-1,i-1,j,dp)) % mod) + 
            ((solve(m,n,moves-1,i,j+1,dp) + solve(m,n,moves-1,i,j-1,dp)) % mod))%mod;
        return dp[i][j][moves];
    }
}