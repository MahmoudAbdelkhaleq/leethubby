class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2) return nums;
        int [] res= new int[2];
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length && count<2;i++){
            if(!set.contains(nums[i])){
                boolean found = false;
                for(int j = i+1;j<nums.length;j++){
                    if(nums[i] == nums[j]){
                        set.add(nums[i]);
                        found = true;
                        break;
                    }
                }
                if(!found){
                    res[count++] = nums[i];
                }
            }
        }
        return res;
    }
}