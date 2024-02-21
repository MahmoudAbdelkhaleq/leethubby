class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left == right) return left;
        int diff = right-left;
        int diffBits = 0;
        while(diff!=0){
            diff /= 2;
            diffBits++;
        }
        long mask = 0;
        for(int i = 30;i>=diffBits;i--){
            mask+=(long)Math.pow(2,i);
        }
        return (int)(left & right & mask);
    }
}