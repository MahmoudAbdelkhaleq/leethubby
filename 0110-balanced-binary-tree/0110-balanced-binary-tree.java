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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return checkBalance(root.left, root.right);
    }
    public static boolean checkBalance(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        int leftHeight = getHeight(left,0);
        int rightHeight = getHeight(right,0);
        if(Math.abs(leftHeight-rightHeight)>1)
            return false;
        if(left == null) return checkBalance(right.left,right.right);
        if(right == null) return checkBalance(left.left,left.right);
        return checkBalance(right.left,right.right) && checkBalance(left.left,left.right);
    }
    public static int getHeight(TreeNode root, int height){
        if(root == null) return height;
        return Math.max(getHeight(root.left,height+1),getHeight(root.right,height+1));
    }
}