class Solution {
    static int [][] direction = new int [][]{{1,0},{-1,0},{0,1},{0,-1}};
    static boolean flip = true;
    public void solve(char[][] board) {
        boolean [][] visited = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j]=='O' && !visited[i][j] && !(i==0 || i==board.length-1 || j==0 || j==board[0].length-1)){
                    visited[i][j] = true;
                    List<Integer[]> region = new LinkedList<>();
                    discoverRegion(board, i, j, visited, region);
                    if(flip){
                        for(Integer[] point : region){
                            board[point[0]][point[1]] = 'X';
                        }
                    }
                    else flip = true;
                }
            }
        }
    }
    private void discoverRegion(char[][] board, int i, int j, boolean[][] visited, List<Integer[]> region){
        region.add(new Integer[]{i, j});
        for(int k = 0;k<4;k++){
            int newI = i+direction[k][0];
            int newJ = j+direction[k][1];
            if(newI>=0 && newI<board.length && newJ>=0 && newJ<board[0].length && !visited[newI][newJ] && board[newI][newJ]=='O'){
                visited[newI][newJ] = true;
                if(newI==0 || newI==board.length-1 || newJ==0 || newJ==board[0].length-1) flip = false;
                discoverRegion(board, newI, newJ, visited, region);
            }
        }
    }
}