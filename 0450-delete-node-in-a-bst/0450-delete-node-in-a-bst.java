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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode current = root;
        while(current!=null && key!=current.val){
            parent = current;
            if(key>current.val)
                current = current.right;
            else
                current = current.left;
        }
        if(current == null) return root;
        //leaf
        if(parent == null){
            
        }
        if(current.left == null && current.right == null){
            if(parent == null) root = null;
            else{
                if(key>parent.val) parent.right = null;
                else parent.left = null;
            }
            return root;
        }
        //one child
        if(current.left == null){
            if(parent == null) root = current.right;
            else{
                if(key>parent.val) parent.right = current.right;
                else parent.left = current.right;
            }
            return root;
        }
        if(current.right == null){
            if(parent == null) root = current.left;
            else{
                if(key>parent.val) parent.right = current.left;
                else parent.left = current.left;
            }
            return root;
        }
        // 2 children
        else{
            TreeNode left = current.left;
            if(parent==null) root = current.right;
            else{
                if(key>parent.val) parent.right = current.right;
                else parent.left = current.right;
            }
            current = current.right;
            while(current.left!=null) current = current.left;
            current.left = left;
        }
        
        return root;
    }
}