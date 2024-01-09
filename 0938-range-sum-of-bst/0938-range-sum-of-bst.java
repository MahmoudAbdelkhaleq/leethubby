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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }
    private int helper(TreeNode node, int low, int high){
        if(node == null) return 0;
        if(node.val<low || node.val>high)return helper(node.left, low, high) + helper(node.right, low, high);;
        return node.val+helper(node.left, low, high) + helper(node.right, low, high);
    }
}