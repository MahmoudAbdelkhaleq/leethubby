class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        // mod value -> count
        int [] modFreq = new int[k];
        modFreq[0] = 1;
        int sumMod = 0;
        for(int i = 0;i<nums.length;i++){
            sumMod = (sumMod + nums[i] % k + k) % k;
            count+=modFreq[sumMod];
            modFreq[sumMod]++;
        }
        return count;
    }
}