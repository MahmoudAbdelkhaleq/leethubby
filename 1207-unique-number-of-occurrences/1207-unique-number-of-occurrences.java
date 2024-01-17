class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            if(map.get(arr[i])==null)map.put(arr[i],1);
            else map.put(arr[i], map.get(arr[i])+1);
        }
        Set<Integer> occ = new HashSet<>();
        for (Map.Entry<Integer, Integer> set :
             map.entrySet()) {
            int n = set.getValue();
            if(occ.contains(n))return false;
            occ.add(set.getValue());
        }
        return true;
    }
}