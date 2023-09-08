class Solution {
    public int totalNQueens(int n) {
        int positions [][] = new int [n][2];
        return dfs(n, positions, 0, "");
    }
    private int dfs(int n, int [][] positions, int count, String cols){
        if(count == n) return 1;
        int possibilities = 0;
        for(int j =0;j<n;j++){
            if(cols.contains(j+""))continue;
            int [] newPos = new int[]{count, j};
            boolean can = true;
            for (int k =0;k<count && can;k++){
                can = can && noAttack(newPos, positions[k]);
            }
            if(can){
                cols+=j;
                positions[count] = newPos;
                possibilities+=dfs(n, positions, count+1, cols);
                cols = cols.substring(0,cols.length()-1);
                positions[count] = new int [2];
            }
        }
        return possibilities;
    }
    private boolean noAttack(int [] pos1, int [] pos2){
        if(Math.abs(pos1[0]-pos2[0])==Math.abs((pos1[1]-pos2[1]))) return false;
        return true;
    }
}