class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        // if(k==0)return 1.0;
        // if(n<3) return 0.0;
        // int onBoard = paths(n, k, row, column);
        // double all = Math.pow(8, k);
        // return (onBoard+0.0)/all;
        int[][] directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2},
                              {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        // Initialize the dynamic programming table
        double[][][] dp = new double[k + 1][n][n];
        dp[0][row][column] = 1.0;

        // Iterate over the number of moves
        for (int moves = 1; moves <= k; moves++) {
            // Iterate over the cells on the chessboard
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Iterate over possible directions
                    for (int[] direction : directions) {
                        int prevI = i - direction[0];
                        int prevJ = j - direction[1];
                        // Check if the previous cell is within the chessboard
                        if (prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n) {
                            // Add the previous probability divided by 8
                            dp[moves][i][j] += dp[moves - 1][prevI][prevJ] / 8.0;
                        }
                    }
                }
            }
        }

        // Calculate total probability by summing probabilities for all cells
        double totalProbability = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalProbability += dp[k][i][j];
            }
        }
        return totalProbability;
    }
    // private static int paths(int n, int k, int row, int column){
    //     if(k==1){
    //         return count(n, row, column);
    //     }
    //     else{
    //         int counter = 0;
    //         if(row+2<n && column+1<n) counter+=paths(n, k-1, row+2, column+1);
    //         if(row+1<n && column+2<n) counter+=paths(n, k-1, row+1, column+2);
    //         if(row+2<n && column-1>=0) counter+=paths(n, k-1, row+2, column-1);
    //         if(row+1<n && column-2>=0) counter+=paths(n, k-1, row+1, column-2);
    //         if(row-1>=0 && column-2>=0) counter+=paths(n, k-1, row-1, column-2);
    //         if(row-2>=0 && column-1>=0) counter+=paths(n, k-1, row-2, column-1);
    //         if(row-1>=0 && column+2<n) counter+=paths(n, k-1, row-1, column+2);
    //         if(row-2>=0 && column+1<n) counter+=paths(n, k-1, row-2, column+1);
    //         return counter;
    //     }
    // }
    // private static int count(int n, int row, int column){
    //     int count = 0;
    //     if(row+2<n && column+1<n) count++;
    //     if(row+1<n && column+2<n) count++;
    //     if(row+2<n && column-1>=0) count++;
    //     if(row+1<n && column-2>=0) count++;
    //     if(row-1>=0 && column-2>=0) count++;
    //     if(row-2>=0 && column-1>=0) count++;
    //     if(row-1>=0 && column+2<n) count++;
    //     if(row-2>=0 && column+1<n) count++;
    //     return count;
    // }
}