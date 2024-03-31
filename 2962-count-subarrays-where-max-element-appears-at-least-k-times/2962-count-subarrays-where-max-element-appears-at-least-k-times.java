class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        int left = 0;
        int maxCount = 0;
        for(int right = 0;right<nums.length;right++){
            if(nums[right] == max){
                maxCount++;
            }
            while(maxCount==k){
                if(nums[left] == max){
                    maxCount--;
                }
                left++;
            }
            res+=left;
        }
        return res;
    }
}