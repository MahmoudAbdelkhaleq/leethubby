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
    int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root,1,0);
        dfs(root,-1,0);
        return maxLength;
    }
    private void dfs(TreeNode node, int dir, int length){
        if(node == null){
            return;
        }
        maxLength = Math.max(length, maxLength);
        if(dir == 1){
            dfs(node.left, -1, length+1);
            dfs(node.right, 1, 1);
        }
        else{
            dfs(node.right, 1, length+1);
            dfs(node.left, -1, 1);
        }
    }
}