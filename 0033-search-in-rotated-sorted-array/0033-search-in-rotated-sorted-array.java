class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = nums.length-1;
        int mid = -1;
        while(start<=end){
            mid = (start+end)/2;
            if(nums[mid]>nums[n-1]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        if(target>nums[n-1]){
            return find(nums, target, 0, start-1);
        }
        else{
            return find(nums, target, start, n-1);
        }
    }
    public int find(int [] nums, int target, int start , int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(target == nums[mid]) return mid;
            if(nums[mid]<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}