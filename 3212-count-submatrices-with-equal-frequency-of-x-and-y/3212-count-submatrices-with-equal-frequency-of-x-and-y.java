class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int [][][] dp = new int[grid.length][grid[0].length][2];
        int count = 0;
        dp[0][0][0] = grid[0][0] == 'X'? 1:0;
        dp[0][0][1] = grid[0][0] == 'Y'? 1:0;
        // first row
        for(int i = 1;i<grid[0].length;i++){
            if(grid[0][i] == 'X'){
                dp[0][i][0] = dp[0][i-1][0]+1;
                dp[0][i][1] = dp[0][i-1][1];
            }
            else if(grid[0][i] == 'Y'){
                dp[0][i][0] = dp[0][i-1][0];
                dp[0][i][1] = dp[0][i-1][1]+1;
            }
            else{
                dp[0][i][0] = dp[0][i-1][0];
                dp[0][i][1] = dp[0][i-1][1];
            }
            if(dp[0][i][0] == dp[0][i][1] && dp[0][i][0]!=0) count++;
        }
        for(int i = 1;i<grid.length;i++){
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
        }
        return count;
    }
}