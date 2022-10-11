class Solution {
    public boolean increasingTriplet(int[] nums) {
        boolean exists = false;
        ArrayList<Integer> unique= new ArrayList<Integer>();
        for(int i =0;i<nums.length;i++){
            if (!unique.contains(nums[i]))
                unique.add(nums[i]);
        }
        if(unique.size()>2){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    for(int k=j+1;k<nums.length;k++){
                        if(nums[i]<nums[j] && nums[j]<nums[k])
                            return true;
                    }
                }
            }
        }
        }
        return exists;
    }
}