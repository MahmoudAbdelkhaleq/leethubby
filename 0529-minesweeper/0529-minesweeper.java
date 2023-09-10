class Solution {
    int [][] dirs = new int [][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if(board[row][col] == 'M'){
            board[row][col] = 'X';
            return board;
        }
        if(board[row][col] == 'E'){
            reveal(board, row, col);
        }
        return board;
    }
    private void reveal(char [][] board, int row, int col){
        int mines = getDigit(board, row, col);
        if(mines != 0) board[row][col] = (char)(mines + '0');
        else{
            board[row][col] = 'B';
            for(int i = 0;i<dirs.length;i++){
                int nextR = row + dirs[i][0];
                int nextC = col + dirs[i][1];
                if(nextR<0 || nextR>=board.length || nextC<0 || nextC>=board[0].length) continue;
                if(board[nextR][nextC] == 'E')
                    reveal(board, nextR, nextC);
            }
        }
    }
    private int getDigit(char[][] board, int row, int col){
        int counter = 0;
        for(int i = 0;i<dirs.length;i++){
            int nextR = row + dirs[i][0];
            int nextC = col + dirs[i][1];
            if(nextR<0 || nextR>=board.length || nextC<0 || nextC>=board[0].length) continue;
            if(board[nextR][nextC] == 'M') counter++;
        }
        return counter;
    }
}