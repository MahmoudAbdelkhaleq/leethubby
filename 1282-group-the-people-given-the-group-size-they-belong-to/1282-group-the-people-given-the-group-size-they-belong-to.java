class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res  = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i =0;i<groupSizes.length;i++){
            map.computeIfAbsent(groupSizes[i], a-> new ArrayList<Integer>()).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> set :
             map.entrySet()) {
            List<Integer> group = new ArrayList<>();
            int size = set.getKey();
            List<Integer> persons = set.getValue();
            for(int i =0;i<persons.size();i++){
                if(group.size()==size){
                    res.add(new ArrayList<>(group));
                    group.clear();
                    i--;
                }
                else group.add(persons.get(i));
            }
            res.add(new ArrayList<>(group));
            group.clear();
        }
        return res;
    }
}