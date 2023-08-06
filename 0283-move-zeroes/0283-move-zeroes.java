class Solution {
    public void moveZeroes(int[] nums) {
        int zIndex = -1;
        int nzIndex = -1;
        int i =0;
        while(i<nums.length || (nzIndex!=-1 && zIndex!=-1)){
            if(zIndex==-1 || nzIndex==-1){
                if(nums[i]==0 && zIndex==-1)zIndex=i;
                else if(nums[i]!=0)nzIndex = i;
            }
            else{
                if(zIndex<nzIndex){
                    int tmp = nums[zIndex];
                    nums[zIndex] = nums[nzIndex];
                    nums[nzIndex] = tmp;
                    i = zIndex;
                    zIndex = -1;
                    nzIndex = -1;
                }
                else{
                    i=zIndex;
                    nzIndex=-1;
                }
            }
            i++;
        }
    }
}