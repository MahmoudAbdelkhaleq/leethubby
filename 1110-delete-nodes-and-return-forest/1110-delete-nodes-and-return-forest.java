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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        HashSet<Integer> toDelete = new HashSet<>();
        for(int n: to_delete){
            toDelete.add(n);
        }
        res.add(root);
        findAndDelete(null, root, toDelete, res);
        return res;
    }
    private void findAndDelete(TreeNode parent, TreeNode node, HashSet<Integer> toDelete, List<TreeNode> res){
        if(node == null){
            return;
        }
        if(toDelete.contains(node.val)){
            // store left and right before removing
            TreeNode left = node.left;
            TreeNode right = node.right;
            // remove the node from the tree
            if(parent == null){
                res.remove(node);
            }
            else{
                if(parent.left == node){
                    parent.left = null;
                }
                else{
                    parent.right = null;
                }
            }
            // if it is a root
            if(left!=null){
                res.add(left);
                findAndDelete(null, left, toDelete, res);
            }
            if(right!=null){
                res.add(right);
                findAndDelete(null, right, toDelete, res);
            }
        }
        else{
            findAndDelete(node, node.left, toDelete, res);
            findAndDelete(node, node.right, toDelete, res);
        }
    }
}