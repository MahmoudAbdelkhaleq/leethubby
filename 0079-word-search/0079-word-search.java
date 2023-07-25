class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[i].length;j++){
                boolean [][] isVisited = new boolean[board.length][board[i].length];
                if(word.charAt(0) == board[i][j] && found(board, word, isVisited, i, j, board[i][j] + "")){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean found(char [][] board, String word, boolean [][] isVisited, int i, int j, String current){
        if(word.length() == current.length()){
            if(word.equals(current))
                return true;
            return false;
        }
        isVisited[i][j]= true;
        boolean exists = false;
        if(i<board.length-1 && word.charAt(current.length())==board[i+1][j] && !isVisited[i+1][j]){
            exists |= found(board, word, isVisited, i+1, j, current + board[i+1][j]);
        }
        if(j<board[i].length-1 && word.charAt(current.length())==board[i][j+1] && !isVisited[i][j+1]){
            exists |= found(board, word, isVisited, i, j+1, current + board[i][j+1]);
        }
        if(i>0 && word.charAt(current.length())==board[i-1][j] && !isVisited[i-1][j]){
            exists |= found(board, word, isVisited, i-1, j, current + board[i-1][j]);
        }
        if(j>0 && word.charAt(current.length())==board[i][j-1] && !isVisited[i][j-1]){
            exists |= found(board, word, isVisited, i, j-1, current + board[i][j-1]);
        }
        isVisited[i][j]= false;
        return exists;
    }
}