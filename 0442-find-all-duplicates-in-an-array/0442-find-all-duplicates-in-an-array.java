class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> res = new HashSet<>();
        boolean [] exists = new boolean[nums.length+1];
        for(int num:nums){
            if(exists[num]) 
                res.add(num);
            else
                exists[num] = true;
        }
        return new ArrayList<>(res);
    }
}