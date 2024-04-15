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
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        sum(root, root.val);
        return totalSum;
    }
    public void sum(TreeNode node, int value){
        if(node.left == null && node.right == null){
            totalSum+=value;
            return;
        }
        if(node.left!=null)sum(node.left, value*10+node.left.val);
        if(node.right!=null)sum(node.right, value*10+node.right.val);
    }
}