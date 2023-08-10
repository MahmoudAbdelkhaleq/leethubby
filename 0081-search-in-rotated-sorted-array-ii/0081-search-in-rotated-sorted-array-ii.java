class Solution {
    public boolean search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(target == nums[i]){
                return true;
            }
        }
        return false;
        // int n = nums.length;
        // int start = 0;
        // int end = n-1;
        // while(start<end){
        //     int mid = start+(end-start)/2;
        //     if(nums[mid]==nums[n-1]){
        //         end++;
        //         start++;
        //         continue;
        //     }
        //     if(nums[mid]>nums[n-1]){
        //         start = mid+1;
        //     }
        //     else end = mid-1;
        // }
        // return  BS(nums, target, 0, start) ||
        //         BS(nums, target, start+1, n-1);
    }
    private boolean BS(int[]nums, int target, int start, int end){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target)
                return true;
            if(nums[mid]>target)
                end = mid-1;
            else start = mid+1;
        }
        return false;
    }
}