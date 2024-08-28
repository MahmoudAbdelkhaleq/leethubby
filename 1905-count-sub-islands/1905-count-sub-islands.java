class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean [][] isVisited = new boolean[grid2.length][grid2[0].length];
        int count = 0;
        for(int i = 0;i<grid2.length;i++){
            for(int j = 0;j<grid2[0].length;j++){
                if(grid2[i][j] == 1 &&  grid1[i][j] == 1 && !isVisited[i][j]){
                    if(discover(i, j, grid2, grid1, isVisited)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    boolean discover(int i, int j, int [][] grid, int [][] original, boolean [][] isVisited){
        if(isVisited[i][j] || grid[i][j] == 0){
            return true;
        }
        isVisited[i][j] = true;
        boolean isSub = original[i][j] == 1;
        if(i>0){
            isSub = discover(i-1, j, grid, original, isVisited) && isSub;
        }
        if(i<grid.length-1){
            isSub = discover(i+1, j, grid, original, isVisited) && isSub;
        }
        if(j>0){
            isSub = discover(i, j-1, grid, original, isVisited) && isSub;
        }
        if(j<grid[0].length-1){
            isSub = discover(i, j+1, grid, original, isVisited) && isSub;
        }
        return isSub;
    }
}