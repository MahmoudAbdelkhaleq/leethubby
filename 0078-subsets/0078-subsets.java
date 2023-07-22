class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans, new ArrayList<Integer>());
        return ans;
    }
    private void helper(int [] nums, int index, List<List<Integer>> ans, List<Integer> current){
        if(index == nums.length){
            ans.add(current);
            return;
        }
        List <Integer> newCurrent = new ArrayList<Integer>(current);
        newCurrent.add(nums[index]);
        helper(nums, index+1, ans, current);
        helper(nums, index+1, ans, newCurrent);
    }
}