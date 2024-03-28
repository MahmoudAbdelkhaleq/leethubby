class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>=k)continue;
            count++;
            int p = nums[i];
            for(int j = i+1;j<nums.length;j++){
                p*=nums[j];
                if(p<k)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}