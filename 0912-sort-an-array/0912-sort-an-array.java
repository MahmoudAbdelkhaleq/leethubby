class Solution {
    public int[] sortArray(int[] nums) {
        return helper(nums);
    }
    public static int [] helper(int [] nums){
        if(nums.length<2) return nums;
        else{
            int [] sorted1 = helper(Arrays.copyOfRange(nums, 0, nums.length/2));
            int [] sorted2 = helper(Arrays.copyOfRange(nums, nums.length/2, nums.length));
            int [] sorted = new int [sorted1.length+sorted2.length];
            int i=0,j=0;
            while(i<sorted1.length && j < sorted2.length){
                if(sorted1[i]<sorted2[j])
                    sorted[i+j]=sorted1[i++];
                else
                    sorted[i+j]=sorted2[j++];
            }
            while(i<sorted1.length){
                sorted[i+j]=sorted1[i++];
            }
            while(j<sorted2.length){
                sorted[i+j]=sorted2[j++];
            }
            return sorted;
        }
    }
}