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
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return moves;
    }
    public int helper (TreeNode node){
        if(node.left == null && node.right == null){
            return node.val;
        }
        int leftExtraCoins = 0;
        int rightExtraCoins = 0;
        if(node.left !=null)
            leftExtraCoins+= helper(node.left)-1;
        if(node.right!=null)
            rightExtraCoins+= helper(node.right)-1;
        node.val += leftExtraCoins + rightExtraCoins;
        moves = moves + Math.abs(leftExtraCoins) + Math.abs(rightExtraCoins);
        return node.val;
    }
}