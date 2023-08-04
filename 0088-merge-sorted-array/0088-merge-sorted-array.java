class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums = new int [m];
        for(int i =0;i<m;i++){
            nums[i]=nums1[i];
        }
        int i = 0;
        int i2 = 0;
        while(i<m && i2<n){
            
            if(nums[i]<nums2[i2]) nums1[i+i2]=nums[i++];
            
            else nums1[i+i2]=nums2[i2++];
        }
        while(i<m) nums1[i+i2]=nums[i++];

        while(i2<n) nums1[i+i2]=nums2[i2++];
    }
}