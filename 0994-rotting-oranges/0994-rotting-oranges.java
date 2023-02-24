class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> queue= new LinkedList<int []>();
        // boolean [][] isVisited = new boolean[grid.length][grid[0].length];
        boolean orangesExist = false;
        for(int i = 0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    int [] x = {i,j,0};
                    queue.add(x);
                }
                if(grid[i][j] == 1){
                    orangesExist = true;
                }
            }
        }
        if(orangesExist)
            return helper(grid,queue);
        else return 0;
    }
    public static int helper(int [][] grid, Queue<int []> queue){
        if(queue.isEmpty()) return -1;
        int [] state = queue.poll();
        int i = state[0];
        int j = state[1];
        int mins = state[2];
        // if(allRotten(grid)) return mins;
        if(i>0 && grid[i-1][j]==1){
            grid[i-1][j]=2;
            int [] x = {i-1,j,mins+1};
            queue.add(x);
        }
        if(j>0 && grid[i][j-1]==1){
            grid[i][j-1]=2;
            int [] x = {i,j-1,mins+1};
            queue.add(x);
        }
        if(i<grid.length-1 && grid[i+1][j]==1){
            grid[i+1][j]=2;
            int [] x = {i+1,j,mins+1};
            queue.add(x);
        }
        if(j<grid[0].length-1 && grid[i][j+1]==1){
            grid[i][j+1]=2;
            int [] x = {i,j+1,mins+1};
            queue.add(x);
        }
        if(allRotten(grid)) return mins+1;
        return helper(grid, queue);
    }
    public static boolean allRotten(int [][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) return false;
            }
        }
        return true;
    }
}