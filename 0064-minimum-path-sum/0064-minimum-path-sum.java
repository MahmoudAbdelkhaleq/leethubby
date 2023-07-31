class Solution {
    public int minPathSum(int[][] grid) {
        int [] [] dp = new int [grid.length][grid[0].length];
        for(int i =0;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(grid, dp, 0, 0);
    }
    private int solve(int [][] grid, int [][] dp, int i, int j){
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        if(i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j] = Math.min(solve(grid, dp, i+1, j), solve(grid, dp, i, j+1)) + grid[i][j];
        return dp[i][j];
    }
}