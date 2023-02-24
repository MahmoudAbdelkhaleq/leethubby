class Solution {
    public int[] productExceptSelf(int[] nums) {
        int max=0;
        int index = -1;
        boolean oneZero = false;
        boolean twoZeros = false;
        for(int i =0;i<nums.length;i++){
            if(Math.abs(nums[i])>=max){
                max = nums[i];
                index = i;
            }
            if(nums[i]==0 && oneZero) twoZeros = true;
            if(nums[i]==0) oneZero = true;
        }
        int productButMax = 1;
        for(int i=0;i<nums.length;i++){
            if(i!=index){
                productButMax*=nums[i];
            }
        }
        int[]result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==index)result[i]=productButMax;
            else{
                if(nums[i]!=0){
                    result[i]=(productButMax/nums[i])*max;
                }
                else{
                    if(twoZeros) result[i]=0;
                    else{
                        result[i]=maxButZeros(nums);
                    }
                }
            }
        }
        return result;
    }
    public static int maxButZeros(int[] nums){
        int x = 1;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0) x*=nums[i];
        }
        return x;
    }
}