class Solution {
    public int maximumDetonation(int[][] bombs) {
        int max = 0;
        for(int i = 0;i<bombs.length;i++){
            int detonated = bomb(bombs, i);
            if(max<detonated) max = detonated;
        }
        return max;
    }
    public static int bomb(int[][]bombs, int i){
        boolean [] isDetonated = new boolean[bombs.length];
        int [] value = new int[1];
        value[0]=0;
        return helperBomb(bombs, i, isDetonated, value);
    }
    public static int helperBomb(int[][]bombs, int i, boolean[] isDetonated, int[] value){
        int [] bomb = bombs[i];
        int x = bomb[0];
        int y = bomb[1];
        int r = bomb[2];
        isDetonated[i] = true;
        value[0]++;
        for(int j = 0; j<bombs.length;j++){
            if(i!=j){
                double dist = Math.sqrt(Math.pow(x-bombs[j][0],2)+Math.pow(y-bombs[j][1],2));
                if(dist<=r && !isDetonated[j]){
                    helperBomb(bombs, j, isDetonated, value);
                }
            }
        }
        return value[0];
    }
}