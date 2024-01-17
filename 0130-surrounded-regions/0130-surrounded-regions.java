class Solution {
    static int [][] direction = new int [][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        boolean [][] visited = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j]=='O' && !visited[i][j] && (i==0 || i==board.length-1 || j==0 || j==board[0].length-1)){
                    visited[i][j] = true;
                    discoverRegion(board, i, j, visited);
                }
            }
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(!visited[i][j])board[i][j]='X';
            }
        }
    }
    private void discoverRegion(char[][] board, int i, int j, boolean[][] visited){
        for(int k = 0;k<4;k++){
            int newI = i+direction[k][0];
            int newJ = j+direction[k][1];
            if(newI>=0 && newI<board.length && newJ>=0 && newJ<board[0].length && !visited[newI][newJ] && board[newI][newJ]=='O'){
                visited[newI][newJ] = true;
                discoverRegion(board, newI, newJ, visited);
            }
        }
    }
}