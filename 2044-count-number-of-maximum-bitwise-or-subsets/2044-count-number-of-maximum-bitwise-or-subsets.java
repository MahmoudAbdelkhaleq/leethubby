class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = nums[0];
        for(int n:nums){
            max|=n;
        }
        int count = 0;
        return backtrack(nums, 0, max, 0);
    }
    public int backtrack(int [] nums, int current, int max, int index){
        if(index == nums.length){
            if(current == max)
                return 1;
            return 0;
        }
        return backtrack(nums, current | nums[index], max, index+1) + 
            backtrack(nums, current, max, index+1);
        
    }
}