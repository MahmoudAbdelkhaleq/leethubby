class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j =0;j<board.length;j++){
                if(board[i][j]!='.'){
                    if(!checkValidity(board,board[i][j],i,j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean checkValidity(char[][] board, char num, int indexI, int indexJ){
        for(int i =0;i<board.length;i++){
            if(i!=indexI){
                if(board[i][indexJ] == num) return false;
            }
        }
        for(int i =0;i<board.length;i++){
            if(i!=indexJ){
                if(board[indexI][i] == num) return false;
            }
        }
        int count =0;
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i+(indexI/3)*3][j+(indexJ/3)*3] == num) count++;
            }
        }
        if(count>1) return false;
        return true;
    }
}