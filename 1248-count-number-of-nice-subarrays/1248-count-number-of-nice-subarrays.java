class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int prefixOdds = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0;i<nums.length;i++){
            prefixOdds+=nums[i]%2;
            if(map.containsKey(prefixOdds-k)){
                count+=map.get(prefixOdds-k);
            }
            map.put(prefixOdds, map.getOrDefault(prefixOdds, 0) + 1);
        }
        return count;
    }
}