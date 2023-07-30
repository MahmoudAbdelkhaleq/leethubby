class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int n: nums) {
            max = Math.max(n, max);
        }

        // initialize 1-d memorization array
        int[] dp = new int[max+1];

        for(int n: nums) {
            dp[n] += n;
        }
        // update dp array
        for(int i=2; i<dp.length; i++) {
            dp[i] = Math.max(dp[i-2] + dp[i], dp[i-1]);
        }
        return dp[dp.length-1];
    }
}