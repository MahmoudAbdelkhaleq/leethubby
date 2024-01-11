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
    
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
    private int dfs(TreeNode node, int max, int min){
        if(node == null) return max-min;
        return Math.max(
            dfs(node.left,Math.max(node.val,max), Math.min(node.val,min)),
            dfs(node.right,Math.max(node.val,max), Math.min(node.val,min))
        );
    }
}