class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long score = 0;
        int max = 0;
        for(int num:nums){
            score+=max;
            max = Math.max(max, num);
        }
        return score;
    }
}