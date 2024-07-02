class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> arr1Map = new HashMap<>();
        HashMap<Integer, Integer> arr2Map = new HashMap<>();
        for(int num:nums1){
            arr1Map.put(num, arr1Map.getOrDefault(num,0)+1);
        }
        for(int num:nums2){
            arr2Map.put(num, arr2Map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer, Integer> set: arr1Map.entrySet()){
            int num = set.getKey();
            int count = Math.min(set.getValue(), arr2Map.getOrDefault(num,0));
            for(int i = 0;i<count;i++){
                result.add(num);
            }
        }
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}