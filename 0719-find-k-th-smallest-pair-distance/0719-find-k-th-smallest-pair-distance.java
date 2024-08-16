class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int maxRange = nums[nums.length-1]-nums[0];
        int minRange = 0;
        while(maxRange > minRange){
            int mid = (maxRange-minRange)/2 + minRange;
            int pairs = countPairs(nums, mid);
            if(pairs<k){
                minRange = mid+1;
            }
            else{
                maxRange = mid;
            }
        }
        return minRange;
    }
    private int countPairs(int [] nums, int range){
        int left = 0;
        int right = 1;
        int count = 0;
        for(;right<nums.length;right++){
            while(nums[right]-nums[left]>range){
                left++;
            }
           count+=right-left;
        }
        return count;
    }
}