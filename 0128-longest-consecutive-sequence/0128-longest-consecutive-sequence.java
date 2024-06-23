class Solution {
    public int longestConsecutive(int[] nums) {
        // num, {lowerlength, upperlength}
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int num:nums){
            if(!map.containsKey(num)){
                int leftLength = map.getOrDefault(num-1,0);
                int rightLength = map.getOrDefault(num+1,0);
                int length = leftLength + rightLength + 1;
                max = Math.max(max, length);
                map.put(num, length);
                map.put(num - leftLength, length);
                map.put(num + rightLength, length);
            }
        }
        // HashSet<Integer> covered = new HashSet<>();
        // for(Map.Entry<Integer, Integer[]> row: map.entrySet()){
        //     int key = row.getKey();
        //     Integer[] value = row.getValue();
        //     if(!covered.contains(key)){
        //         covered.add(key);
        //         while(map.containsKey(key+value[1]+1)){
        //             value[1]++;
        //             covered.add(key+value[1]+1);
        //         }
        //         while(map.containsKey(key-value[0]-1)){
        //             value[0]++;
        //             covered.add(key-value[0]-1);
        //         }
        //     }
        //     int length = value[0] + value[1] + 1;
        //     if(max<length){
        //         max = length;
        //     }
        // }
        return max;
    }
}