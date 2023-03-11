class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), ans);
        return ans;

    }

    private void helper(int[] candidates, int target, int start, ArrayList<Integer> tempList, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(tempList));
            return;
        } 
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>target){
                break;
            }
            tempList.add(candidates[i]);
            helper(candidates, target-candidates[i], i, tempList, ans);
            //remove element from tempList
            tempList.remove(tempList.size()-1);
        }
    }
}