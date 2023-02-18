class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        // return nums[nums.length/2];
        return (solve(nums));
    }
    public int solve(int[] nums){
        int count = 1;
        int major =nums[0];
        for(int i =1;i<nums.length;i++){
            if(count == 0){
                major = nums[i];
            }
            if(nums[i] == major) count++;
            else count --;
        }
        return major;
    }
}