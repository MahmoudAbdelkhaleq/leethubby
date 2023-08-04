class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int [n][n];
        for(int i =0;i<n;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return solve(triangle, dp, 0, 0);
    }
    private int solve (List<List<Integer>> triangle, int [][] dp, int level, int num){
        if(level>=triangle.size()){
            return Integer.MAX_VALUE;
        }
        if(level==triangle.size()-1){
            dp[level][num] = triangle.get(level).get(num);
            return dp[level][num];
        }
        if(dp[level][num]!=Integer.MAX_VALUE){
            return dp[level][num];
        }
        dp[level][num] = Math.min(solve(triangle, dp, level+1, num), solve(triangle, dp, level+1, num+1))
                +triangle.get(level).get(num);
        return dp[level][num];
    }
}