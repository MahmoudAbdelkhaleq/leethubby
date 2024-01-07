class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        int i = 0;
        while(i<nums.length-2){
            int currDiff = nums[i]-nums[i+1];
            int j = i+1;
            for(;j<nums.length;j++){
                if(nums[j-1]-nums[j]!=currDiff)break;
            }
            int n = j-i-2;
            if(n>0)
                res+=(n*(n+1)/2);
            i=j-1;
        }
        return res;
    }
}