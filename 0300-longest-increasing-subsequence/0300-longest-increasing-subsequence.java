class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int [nums.length];
        for(int i =0;i<dp.length;i++){
            dp[i]=1;
        }
        for (int i = 0; i < nums.length; ++i)
            for (int j = 0; j < i; ++j)
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
        for(int i = 0;i<dp.length;i++){
            System.out.print(dp[i] + " ");
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}