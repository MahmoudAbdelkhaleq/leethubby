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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length-1, 0, preorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int [] inorder, int startI, int endI, int startP, int endP){
        if(startI>endI){
            return null;
        }
        int index = startP;
        for(int i = startI; i<=endI; i++){
            if(preorder[startP] == inorder[i]){
                index = i;
                break;
            }
        }
        TreeNode leftSubTree = buildTree(preorder, inorder, startI, index-1, startP+1, startP+index-startI);
        TreeNode rightSubTree = buildTree(preorder, inorder, index+1, endI, startP+index-startI+1, endP);
        return new TreeNode(inorder[index], leftSubTree, rightSubTree);
    }
}