class Solution {
    public int findComplement(int num) {
        int bits = getLog(num);
        long roof = (long) Math.pow(2, bits) - 1;
        return (int)(roof-num);
    }
    public int getLog(int num){
        int log = 0;
        for(long i = 1;i<=num;i*=2){
            log++;
        }
        return log;
    }
}