class Solution {
    public int longestSubarray(int[] nums) {
        boolean foundZero = false;
        int maxLength = 0;
        int currentLength = 0;
        int onesBefore = 0;
        int onesAfter = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                if(!foundZero){
                    foundZero = true;
                }
                else{
                    onesBefore = onesAfter;
                    currentLength = onesAfter;
                    onesAfter = 0;
                }
            }
            else{
                if(foundZero)
                    onesAfter++;
                else
                    onesBefore++;
                currentLength++;
            }
            if(currentLength>maxLength) maxLength = currentLength;
        }
        if(!foundZero) return nums.length-1;
        return maxLength;
    }
}