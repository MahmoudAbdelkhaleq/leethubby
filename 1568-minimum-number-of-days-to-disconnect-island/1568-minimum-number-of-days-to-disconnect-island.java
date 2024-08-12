class Solution {
    public int minDays(int[][] grid) {
        Set<String> set = new HashSet<>();
        int [][] count = new int[grid.length][grid[0].length];
        if(!isConnected(grid, set, count)){
            return 0;
        }
        if(set.size() <= 2){
            return set.size();
        }
        Set<String> toBeRemoved = new HashSet<>();
        for(String s:set){
            String [] index = s.split(",");
            int i = Integer.parseInt(index[0]);
            int j = Integer.parseInt(index[1]);
            int num = count[i][j];
            if(num==1){
                return 1;
            }
            else{
                toBeRemoved.add(s);
            }
        }
        for(String s:toBeRemoved){
            String [] index = s.split(",");
            int i = Integer.parseInt(index[0]);
            int j = Integer.parseInt(index[1]);
            grid[i][j] = 0;
            if(!isConnected(grid, new HashSet<>(), new int [grid.length][grid[0].length])){
                return 1;
            }
            grid[i][j] = 1;
        }
        return 2;
    }
    private boolean isConnected(int [][] grid, Set<String> set, int [][] count){
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j< grid[0].length;j++){
                if(grid[i][j] == 1){
                    if(set.isEmpty()){
                        // discover first encountered island
                        discover(grid, set, i, j, new boolean[grid.length][grid[0].length], count);
                    }
                    else{
                        if(!set.contains(i+","+j)){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    private void discover(int [][] grid, Set<String> set, int i, int j, boolean [][] isVisited, int[][] count){
        if(isVisited[i][j] || grid[i][j] == 0){
            return;
        }
        isVisited[i][j] = true;
        set.add(i+","+j);
        if(i>0){
            discover(grid, set, i-1, j, isVisited, count);
            count[i-1][j]++;
        }
        if(i<grid.length-1){
            discover(grid, set, i+1, j, isVisited, count);
            count[i+1][j]++;
        }
        if(j>0){
            discover(grid, set, i, j-1, isVisited, count);
            count[i][j-1]++;
        }
        if(j<grid[0].length-1){
            discover(grid, set, i, j+1, isVisited, count);
            count[i][j+1]++;
        }
    }
}