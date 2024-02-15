class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        long ans = -1;
        long sum = 0;
        while(i<nums.length){
            if(sum>nums[i] && i>=2){
                ans = nums[i] + sum;
            }
            sum+=nums[i++];
        }
        return ans;
    }
}