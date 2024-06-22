class Solution {
    // public int numberOfSubarrays(int[] nums, int k) {
    //     int count = 0;
    //     int prefixOdds = 0;
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     map.put(0, 1);
    //     for(int i = 0;i<nums.length;i++){
    //         prefixOdds+=nums[i]%2;
    //         if(map.containsKey(prefixOdds-k)){
    //             count+=map.get(prefixOdds-k);
    //         }
    //         map.put(prefixOdds, map.getOrDefault(prefixOdds, 0) + 1);
    //     }
    //     return count;
    // }
    public int numberOfSubarrays(int [] nums, int k){
        int count = 0;
        int start = 0;
        int evenVals = 0;
        int oddVals = 0;
        for(int i = 0;i<nums.length;i++){
            oddVals+=nums[i]%2;
            if(oddVals == k){
                evenVals = 0;
                while(oddVals == k){
                    oddVals-=nums[start++]%2;
                    evenVals++;
                }
            }
            count+=evenVals;
        }
        return count;
    }
}