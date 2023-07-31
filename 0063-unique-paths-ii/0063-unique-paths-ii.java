class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [] [] dp = new int [obstacleGrid.length][obstacleGrid[0].length];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(obstacleGrid, dp, 0, 0);
    }
    private int solve(int [][] grid, int [][] dp, int i, int j){
        if(i>=grid.length || j >= grid[0].length){
            return 0;
        }
        if(grid[i][j] == 1) return 0; 
        if(i==grid.length-1 && j == grid[0].length-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        dp[i][j] = solve(grid, dp, i+1, j) + solve(grid, dp, i, j+1);
        return dp[i][j];
    }
}