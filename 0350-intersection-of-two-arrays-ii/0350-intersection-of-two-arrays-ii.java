class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> arrMap = new HashMap<>();
        for(int num:nums1){
            arrMap.put(num, arrMap.getOrDefault(num,0)+1);
        }
        for(int num:nums2){
            if(arrMap.getOrDefault(num,0)>0){
                result.add(num);
                arrMap.put(num,arrMap.get(num)-1);
            }
        }
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}