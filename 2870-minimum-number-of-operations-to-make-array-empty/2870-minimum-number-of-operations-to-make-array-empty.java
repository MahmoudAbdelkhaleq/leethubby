class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
            map.merge(nums[i], 1, Integer::sum);
        int res = 0;
        for (Integer num : map.values()) {
            if(num == 1) return -1;
            if(num%3 == 0)res+=num/3;
            else res+=num/3 + 1;
        }
        return res;
    }
}