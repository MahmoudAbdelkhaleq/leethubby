class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(k, n, 1, res, curr);
        return res;
    }
    private void dfs(int k, int n, int num, List<List<Integer>> res, List<Integer> curr){
        if(n==0 && k==0){
            res.add(new ArrayList<>(curr));
        }
        if(k==0)return;
        if(n<=0)return;
        if(9-num<k-1)return;
        curr.add(num);
        dfs(k-1, n-num, num+1, res, curr);
        curr.remove(Integer.valueOf(num));
        dfs(k, n, num+1, res, curr);
    }
}