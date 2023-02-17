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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) 
            return root;
        swap(root);
        return root;
    }
    public static void swap(TreeNode root){
        if(root == null)return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        swap(root.left);
        swap(root.right);
        
    }
}