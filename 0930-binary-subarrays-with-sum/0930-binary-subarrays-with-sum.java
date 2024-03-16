class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int [] freq = new int [nums.length+1];
        int sum = 0;
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            if(sum == goal){
                res++;
            }
            if(sum>=goal){
                res+=freq[sum-goal];
            }
            freq[sum]++;
        }
        return res;
    }
}