class Solution {
    
    private int [][] dp;
    
    public int maxValue(int[][] events, int k) {
        dp = new int [k+1][events.length];
        Arrays.sort(events, (a,b) ->a[0] - b[0]);
        for(int i = 1;i<k+1;i++){
            for(int j =0;j<events.length;j++){
                dp[i][j]=-1;
            }
        }
        return dfs(k, 0, events);
        
    }
    private int dfs (int count, int index, int[][] events){
        if(count == 0) return 0;
        if(index == events.length) return 0;
        if (dp[count][index] != -1) {
            return dp[count][index];
        }
        int nextIndex = nextEventIndex(events, events[index][1]);
        dp[count][index] = Math.max(dfs(count, index + 1, events), events[index][2] + dfs(count -1, nextIndex, events));
        return dp[count][index];
    }
    
    public static int nextEventIndex(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }   
}