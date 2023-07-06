class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int index = 0;
        int minLength = Integer.MAX_VALUE;
        boolean viable = false;
        for(int i =0;i<nums.length;i++){
            sum= sum + nums[i];
            if(sum>=target){
                viable = true;
                while(sum>=target){
                    sum-=nums[index++];
                }
                if(minLength>i-index+2)minLength = i-index+2;
            }
        }
        if(!viable) return 0;
        return minLength;
    }
}