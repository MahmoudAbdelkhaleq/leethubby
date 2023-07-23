class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        add(nums, ans, new ArrayList<Integer>());
        return ans;
    }
    private static void add(int [] nums, List<List<Integer>> ans, List<Integer> current){
        if(current.size()==nums.length){
            ans.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(!current.contains(nums[i])){
                current.add(nums[i]);
                add(nums, ans, current);
                current.remove(current.size()-1);
            }
        }
    }
}