class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int start = 0;
        int countZeros = 0;
        int count = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                countZeros++;
            }
            if(k>=countZeros)count++;
            else{
                if(nums[start++]==0)countZeros--;
                count--;
                i--;
                countZeros--;
            }
            if(count>max){
               max = count;
            }
        }
        return max;
    }
}