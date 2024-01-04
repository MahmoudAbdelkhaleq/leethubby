class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> set :
             map.entrySet()) {
            int num = set.getValue();
            if(num == 1) return -1;
            if(num%3 == 0)res+=num/3;
            else res+=num/3 + 1;
        }
        return res;
    }
}