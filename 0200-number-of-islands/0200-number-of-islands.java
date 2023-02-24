class Solution {
    public int numIslands(char[][] grid) {
        boolean [][] isVisited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(!isVisited[i][j] && grid[i][j] == '1'){
                    discoverIsland(isVisited,grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void discoverIsland(boolean[][] isVisited, char [][]grid, int i, int j){
        isVisited[i][j] = true;
        if(i>0 && !isVisited[i-1][j] && grid[i-1][j] == '1')discoverIsland(isVisited,grid,i-1,j);
        if(j>0 && !isVisited[i][j-1] && grid[i][j-1] == '1')discoverIsland(isVisited,grid,i,j-1);
        if(i<grid.length-1 && !isVisited[i+1][j] && grid[i+1][j] == '1')discoverIsland(isVisited,grid,i+1,j);
        if(j<grid[0].length-1 && !isVisited[i][j+1] && grid[i][j+1] == '1')discoverIsland(isVisited,grid,i,j+1);
    }
    public static boolean isAllVisited(boolean[][] isVisited){
        for(int i =0;i<isVisited.length;i++){
            for(int j =0;j<isVisited[0].length;j++){
                if(!isVisited[i][j]) return false;
            }
        }
        return true;
    }
}