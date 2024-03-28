class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        while(end<nums.length){
            if(freq.getOrDefault(nums[end],0)<k){
                freq.put(nums[end],freq.getOrDefault(nums[end],0)+1);
                if(end-start+1>maxLength) maxLength = end-start+1;
                end++;
            }
            else{
                freq.put(nums[start],freq.get(nums[start])-1);
                start++;
            }
        }
        return maxLength;
    }
}