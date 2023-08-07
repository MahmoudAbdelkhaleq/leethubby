class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            if(map.get(arr[i])==null)map.put(arr[i],1);
            else map.put(arr[i], map.get(arr[i])+1);
        }
        List<Integer> occ = new ArrayList<>();
        for (Map.Entry<Integer, Integer> set :
             map.entrySet()) {
            occ.add(set.getValue());
        }
        for(int i =0;i<occ.size();i++){
            int val = occ.remove(i--);
            if(occ.contains(val))return false;
        }
        return true;
    }
}