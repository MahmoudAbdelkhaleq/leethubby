class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int diff = right-left;
        int diffBits = 0;
        while(diff!=0){
            diff /= 2;
            diffBits++;
        }
        int mask = 0;
        for(int i = 30;i>=diffBits;i--){
            mask+=Math.pow(2,i);
        }
        return left & right & mask;
    }
}