class Solution {
    public int equalPairs(int[][] grid) {
        int [][] newGrid = new int [grid.length][grid.length];
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid.length;j++){
                newGrid[j][i]=grid[i][j];
            }
        }
        int count = 0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid.length;j++){
                if(checkEquality(grid[i], newGrid[j]))
                    count++;
            }
        }
        return count;
    }
    private boolean checkEquality(int [] a1, int [] a2){
        for(int i = 0;i<a1.length;i++){
            if(a1[i] != a2[i])
                return false;
        }
        return true;
    }
}