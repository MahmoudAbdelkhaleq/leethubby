class Solution {
    public int removeDuplicates(int[] nums) {
        int last = 0;
        int num = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(num != nums[i]){
                nums[++last] = nums[i];
                num = nums[i];
            }
        }
        return last+1;
    }
}