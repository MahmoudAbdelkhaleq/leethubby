/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, res, new ArrayList<>());
        return res;
    }
    private void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> current){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(root.val == targetSum){
                current.add(root.val);
                res.add(new ArrayList<>(current));
                current.remove(current.size()-1);
            } 
            return;
        }
        current.add(root.val);
        targetSum-=root.val;
        dfs(root.left, targetSum, res, current);
        dfs(root.right, targetSum, res, current);
        current.remove(current.size()-1);
        targetSum+=root.val;
    }
}