class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
        }
        int left = 0;
        int right = sum-nums[0];
        for(int i = 1;i<nums.length;i++){
            if(left == right) return i-1;
            right-=nums[i];
            left+=nums[i-1];
        }
        if(left == right) return nums.length-1;
        return -1;
    }
}