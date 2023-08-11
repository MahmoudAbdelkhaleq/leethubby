class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ops =0;
        int i =0;
        int j =nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==k){
                i++;
                j--;
                ops++;
            }
            else if(nums[i]+nums[j]>k) j--;
            else i++;
        }
        return ops;
    }
}