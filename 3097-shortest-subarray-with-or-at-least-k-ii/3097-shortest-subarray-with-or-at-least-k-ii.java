class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int [] bitCount = new int [32];
        int start = 0;
        int minLength = nums.length+1;
        for(int i = 0; i<nums.length; i++){
            updateBitCount(bitCount, nums[i], 1);
            while(convertBitCountsToNumber(bitCount) >= k && start<=i){
                minLength = Math.min(minLength, i - start + 1);
                updateBitCount(bitCount, nums[start], -1);
                start++;
            }
        }
        return minLength == nums.length+1  ? -1 : minLength;
    }
    private void updateBitCount(int [] bitCount, int num, int diff){
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            // Check if bit is set at current position
            if (((num >> bitPosition) & 1) != 0) {
                bitCount[bitPosition] += diff;
            }
        }
    }
    private int convertBitCountsToNumber(int[] bitCount) {
        int result = 0;
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            if (bitCount[bitPosition] != 0) {
                result |= 1 << bitPosition;
            }
        }
        return result;
    }
}