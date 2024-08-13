class Solution {
    // Set<String> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, res, new ArrayList<>());
        return res;
    }
    private void dfs(int [] candidates, int target, int index, List<List<Integer>> res, List<Integer> currentList){
        if(target<0){
            return;
        }
        if(target == 0){
            // String s = uniqueString(currentList);
            // if(!set.contains(s)){
            //     res.add(new ArrayList<>(currentList));
            //     set.add(s);
            // }
            res.add(new ArrayList<>(currentList));
            return;
        }
        for(int i = index;i<candidates.length && candidates[i]<=target;i++){
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            // dfs(candidates, target, index+1, res, currentList);
            currentList.add(candidates[i]);
            dfs(candidates, target-candidates[i], i+1, res, currentList);
            currentList.remove(currentList.size()-1);
        }
    }
    // private String uniqueString(List<Integer> list){
    //     int[] arr = new int [51];
    //     for(int n:list){
    //         arr[n]++;
    //     }
    //     StringBuilder s = new StringBuilder();
    //     for(int i=0;i<arr.length;i++){
    //         if(arr[i]>0){
    //             s.append(i+":"+arr[i]+",");
    //         }
    //     }
    //     return s.toString();
    // }
}