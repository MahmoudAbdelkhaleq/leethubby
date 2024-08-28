class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // List<List<Integer[]>> islands2 = new ArrayList<>();
        boolean [][] isVisited = new boolean[grid2.length][grid2[0].length];
        int count = 0;
        for(int i = 0;i<grid2.length;i++){
            for(int j = 0;j<grid2[0].length;j++){
                if(grid2[i][j] == 1 &&  grid1[i][j] == 1 && !isVisited[i][j]){
                    List<Integer[]> island = new ArrayList<>();
                    discover(i, j, grid2, island, isVisited);
                    boolean contained = true;
                    for(Integer[] cell:island){
                        if(grid1[cell[0]][cell[1]] == 0){
                            contained = false;
                            break;
                        }
                    }
                    if(contained){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    void discover(int i, int j, int [][] grid, List<Integer[]> island, boolean [][] isVisited){
        if(isVisited[i][j] || grid[i][j] == 0){
            return;
        }
        isVisited[i][j] = true;
        island.add(new Integer[]{i, j});
        if(i>0){
            discover(i-1, j, grid, island, isVisited);
        }
        if(i<grid.length-1){
            discover(i+1, j, grid, island, isVisited);
        }
        if(j>0){
            discover(i, j-1, grid, island, isVisited);
        }
        if(j<grid[0].length-1){
            discover(i, j+1, grid, island, isVisited);
        }
    }
}