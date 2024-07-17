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
        HashSet<TreeNode> forest = new HashSet<>();
        HashSet<Integer> toDelete = new HashSet<>();
        for(int n: to_delete){
            toDelete.add(n);
        }
        forest.add(root);
        findAndDelete(null, root, toDelete, forest);
        return new ArrayList<>(forest);
    }
    private void findAndDelete(TreeNode parent, TreeNode node, HashSet<Integer> toDelete, HashSet<TreeNode> forest){
        if(node == null){
            return;
        }
        if(toDelete.contains(node.val)){
            // store left and right before removing
            TreeNode left = node.left;
            TreeNode right = node.right;
            // remove the node from the tree
            // if the parent of a node is null then this node is a root of a tree and needs to be removed from the list
            if(parent == null){
                forest.remove(node);
            }
            // derefrence the node from its parent
            else{
                if(parent.left == node){
                    parent.left = null;
                }
                else{
                    parent.right = null;
                }
            }
            // add the 2 new trees
            if(left!=null){
                forest.add(left);
                findAndDelete(null, left, toDelete, forest);
            }
            if(right!=null){
                forest.add(right);
                findAndDelete(null, right, toDelete, forest);
            }
        }
        else{
            findAndDelete(node, node.left, toDelete, forest);
            findAndDelete(node, node.right, toDelete, forest);
        }
    }
}