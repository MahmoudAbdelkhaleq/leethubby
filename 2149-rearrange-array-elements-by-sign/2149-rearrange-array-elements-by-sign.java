class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] p = new int [nums.length/2];
        int [] n = new int [nums.length/2];
        int ip = 0;
        int in = 0;
        for(int num:nums){
            if(num>0) p[ip++] = num;
            else n[in++] = num;
        }
        for(int i = 0;i<nums.length;i=i+2){
            nums[i] = p[i/2];
            nums[i+1] = n[i/2];
        }
        return nums;
    }
}