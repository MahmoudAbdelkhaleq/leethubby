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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        InOrderSum(root);
        return root;
    }
    public void InOrderSum(TreeNode node){
        if(node == null)
            return;
        InOrderSum(node.right);
        sum += node.val;
        node.val = sum;
        InOrderSum(node.left);
    }
}