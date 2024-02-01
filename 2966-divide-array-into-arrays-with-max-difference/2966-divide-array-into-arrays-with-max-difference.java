class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        boolean f = true;
        int [][] res = new int [nums.length/3][3];
        int c = 0;
        for(int i = 0;i<nums.length-2;i+=3){
            if(nums[i+1]-nums[i]>k || nums[i+2]-nums[i+1]>k || nums[i+2]-nums[i]>k){
                f = false;
                break;
            }
            else{
                res[c][0] = nums[i];
                res[c][1] = nums[i+1];
                res[c++][2] = nums[i+2];
            }
        }
        if(!f) return new int [0][];
        res[nums.length/3 -1][2] = nums[nums.length-1];
        return res;
    }
}