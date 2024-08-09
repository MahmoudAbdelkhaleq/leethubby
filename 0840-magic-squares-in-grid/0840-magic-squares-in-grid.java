class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length<3 || grid[0].length<3){
            return 0;
        }
        int count = 0;
        for(int i = 0;i<grid.length-2;i++){
            int [] counter = new int[16];
            for(int k = 0;k<3;k++){
                for(int l = 0;l<3;l++){
                    counter[grid[i+k][l]]++;
                }
            }
            if(isMagical(grid, i, 0, counter)){
                count++;
            }
            for(int j = 1;j<grid[0].length-2;j++){
                for(int k = 0;k<3;k++){
                    counter[grid[i+k][j-1]]--;
                    counter[grid[i+k][j+2]]++;
                }
                if(isMagical(grid, i, j, counter)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isMagical(int [][] grid, int i1, int j1, int [] counter){
        for(int i = 1;i<10;i++){
            if(counter[i]!=1){
                return false;
            }
        }
        int sum = grid[i1][j1] + grid[i1+1][j1] + grid[i1+2][j1];
        for(int i = 1;i<3;i++){
            if(grid[i1][j1+i] + grid[i1+1][j1+i] + grid[i1+2][j1+i]!=sum){
                return false;
            }
        }
        for(int i = 0;i<3;i++){
            if(grid[i1+i][j1] + grid[i1+i][j1+1] + grid[i1+i][j1+2]!=sum){
                return false;
            }
        }
        if(grid[i1][j1]+grid[i1+1][j1+1]+grid[i1+2][j1+2]!=sum){
            return false;
        }
        if(grid[i1][j1+2]+grid[i1+1][j1+1]+grid[i1+2][j1]!=sum){
            return false;
        }
        return true;
    }
}