class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i =0; i<nums.length;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int diff = o1.getValue()-o2.getValue();
                if(diff!=0){
                    return diff;
                }
                return o2.getKey()-o1.getKey();
            }
        });
        int i = 0;
        for(Map.Entry<Integer, Integer> row: list){
            int count = row.getValue();
            int key = row.getKey();
            for(int j = 0;j<count;j++){
                nums[i+j] = key;
            }
            i+=count;
        }
        return nums;
    }
}