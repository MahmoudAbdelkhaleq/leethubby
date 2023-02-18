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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return Math.max(Math.max(getHeight(root.left,0)+getHeight(root.right,0),diameterOfBinaryTree(root.left)),diameterOfBinaryTree(root.right));
    }
    public static int getHeight(TreeNode root, int height){
        if(root == null) return height;
        return Math.max(getHeight(root.left,height+1),getHeight(root.right,height+1));
    }
}