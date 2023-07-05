class Solution {
    public int[] getAverages(int[] nums, int k) {
        int [] avgs = new int [nums.length];
        long sum = 0;
        for(int i =0;i<nums.length;i++){
            if(i<k || i>nums.length-k-1)avgs[i]=-1;
            sum = sum + nums[i];
            if(i>=2*k){
                avgs[i-k]=(int)(sum/(2*k+1));
                sum-=nums[i-2*k];
            }
        }
        return avgs;
    }
}