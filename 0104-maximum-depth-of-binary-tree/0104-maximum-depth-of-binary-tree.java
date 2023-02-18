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
    public int maxDepth(TreeNode root) {
        return getHeight(root,0);
    }
    public static int getHeight(TreeNode root, int height){
        if(root == null) return height;
        return Math.max(getHeight(root.left,height+1),getHeight(root.right,height+1));
    }
}