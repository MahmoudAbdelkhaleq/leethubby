class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int start = -1;
        int end = start;
        long count = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                if(start!=-1) end = i;
                else{
                    start = i; end = i;
                }
            }
            else{
                if(start!=-1){
                    count = count + summation(end-start+1);
                    start = -1; end = start;
                }
            }
        }
        if(start!=-1) count = count + summation(end-start+1);
        return count;
    }
    private static long summation(long n){
        long result = 0;
        for(int i = 1; i<=n; i++){
            result+=i;
        }
        return result;
    }
}