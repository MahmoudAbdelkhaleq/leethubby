class Solution {
    public int minimizeMax(int[] nums, int p) {
        if(nums.length==1 || p==0) return 0;
        Arrays.sort(nums);
        int max = nums[nums.length-1]-nums[0];
        int min =0;
        while(min<max){
            int mid = min + (max-min)/2;
            if(countPairs(nums, mid)>=p)
                max = mid;
            else 
                min = mid+1;
        }
        return min;
    }
    private int countPairs(int [] nums, int diff){
        int count = 0;
        for(int i =0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]<=diff){
                count++;
                i++;
            }
        }
        return count;
    }
    
}