class Solution {
    static final int[][] directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2},
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    static double [][][]dp;

    public double knightProbability(int n, int k, int row, int column) {
        if(k==0)return 1.0;
        if(n<3) return 0.0;
        dp = new double[k+1][n][n];
        for(int i = 0;i<k+1;i++){
            for(int j =0;j<n;j++){
                Arrays.fill(dp[i][j],-1.0);
            }
        }
        dp[k][row][column] = paths(n, k, row, column);
        return (dp[k][row][column]+0.0)/8;
    }
    private static double paths(int n, int k, int row, int column){
        if(k==1){
            return count(n, row, column)+0.0;
        }
        else{
            double counter = 0;
            for(int i =0;i<directions.length;i++){
                int nextRow = row+directions[i][0];
                int nextColumn = column+directions[i][1];
                if(nextRow>-1 && nextRow<n && nextColumn>-1 && nextColumn<n){
                    if(dp[k-1][nextRow][nextColumn]==-1.0){
                        dp[k-1][nextRow][nextColumn] = (paths(n, k-1, nextRow, nextColumn))/8;
                        counter+=dp[k-1][nextRow][nextColumn];
                    }
                    else
                        counter+=dp[k-1][nextRow][nextColumn];
                }
            }
            return counter;
        }
    }
    private static int count(int n, int row, int column){
        int count = 0;
        for(int i =0;i<directions.length;i++){
            int nextRow = row+directions[i][0];
            int nextColumn = column+directions[i][1];
            if(nextRow>-1 && nextRow<n && nextColumn>-1 && nextColumn<n){
                count++;
            }
        }
        return count;
    }
}