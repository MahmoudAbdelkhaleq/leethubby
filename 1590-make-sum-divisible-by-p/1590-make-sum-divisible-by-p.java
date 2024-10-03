class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for(int n:nums){
            sum = (sum + n) % p;
        }
        int remainder = sum%p;
        if(remainder == 0){
            return 0;
        }
        Map<Integer, Integer> prefixMod = new HashMap<>();
        prefixMod.put(0,-1);
        int currentPrefix = 0;
        int minLength = nums.length;
        for(int i = 0;i<nums.length;i++){
            currentPrefix = (currentPrefix + nums[i])%p;
            int modValueNeeded = (currentPrefix - remainder + p) % p;
            if(prefixMod.containsKey(modValueNeeded)){
                int length = i - prefixMod.get(modValueNeeded);
                minLength = Math.min(minLength, length);
            }
            prefixMod.put(currentPrefix, i);
        }
        return minLength == nums.length ? -1 : minLength;
    }
}