class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int [][][] dp = new int[grid.length][grid[0].length][2];
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(j==0){
                    if(grid[i][0] == 'X'){
                        dp[i][0][0] = 1;
                    }
                    if(grid[i][0] == 'Y'){
                        dp[i][0][1] = 1;
                    }
                }
                else{
                    if(grid[i][j] == 'X'){
                        dp[i][j][0] = dp[i][j-1][0]+1;
                        dp[i][j][1] = dp[i][j-1][1];
                    }
                    else if(grid[i][j] == 'Y'){
                        dp[i][j][0] = dp[i][j-1][0];
                        dp[i][j][1] = dp[i][j-1][1]+1;
                    }
                    else{
                        dp[i][j][0] = dp[i][j-1][0];
                        dp[i][j][1] = dp[i][j-1][1];
                    } 
                }
            }
            if(i>0){
                for(int j = 0;j<dp[0].length;j++){
                    dp[i][j][0]+=dp[i-1][j][0];
                    dp[i][j][1]+=dp[i-1][j][1];
                    if(dp[i][j][0] == dp[i][j][1] && dp[i][j][0]!=0)
                        count++;
                }
            }
            else{
                for(int j = 0;j<dp[0].length;j++){
                    if(dp[i][j][0] == dp[i][j][1] && dp[i][j][0]!=0)
                        count++;
                }
            }
        }
        return count;
    }
}