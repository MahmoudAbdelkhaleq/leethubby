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
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        int ans1 = Math.max(Math.abs(root.val-max(root.left)),Math.abs(root.val-min(root.left)));
        int ans2 = Math.max(Math.abs(root.val-max(root.right)),Math.abs(root.val-min(root.right)));
        if(root.left == null) ans1 = 0;
        if(root.right == null) ans2 = 0;
        int ans3 = maxAncestorDiff(root.left);
        int ans4 = maxAncestorDiff(root.right);
        int ans5 = Math.max(ans1, ans2);
        int ans6 = Math.max(ans3, ans4);
        int ans = Math.max(ans5, ans6);
        return ans;
    }
    private int max(TreeNode node){
        if(node == null) return 0;
        return Math.max(node.val, Math.max(max(node.left), max(node.right)));
    }
    private int min(TreeNode node){
        if(node == null) return 0;
        return minf(node);
    }
    private int minf(TreeNode node){
        if(node == null) return 100001;
        return Math.min(node.val, Math.min(minf(node.left), minf(node.right)));
    }
}