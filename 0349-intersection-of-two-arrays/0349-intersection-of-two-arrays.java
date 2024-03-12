class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;int j = 0;
        Set<Integer> res = new HashSet<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                res.add(nums2[j]);
                i++;j++;
            }
            else{
                if(nums1[i]>nums2[j]) j++;
                else i++;
            }
        }
        int [] resArr = new int [res.size()];
        i=0;
        for(int n:new ArrayList<>(res)){
            resArr[i++] = n;
        }
        return resArr;
    }
}