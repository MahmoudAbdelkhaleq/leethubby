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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;
        if(root1.val != root2.val){
            return false;
        }
        return isEquiv(root1, root2);
    }
    private boolean isEquiv(TreeNode node1, TreeNode node2){
        List<TreeNode> children1 = new ArrayList<>();
        List<TreeNode> children2 = new ArrayList<>();
        if(node1.left!=null){
            children1.add(node1.left);
        }
        if(node1.right!=null){
            children1.add(node1.right);
        }
        if(node2.left!=null){
            children2.add(node2.left);
        }
        if(node2.right!=null){
            children2.add(node2.right);
        }
        if(children1.size()!=children2.size())
            return false;
        if(children1.size() == 0)
            return true;
        if(children1.size() == 1){
            return flipEquiv(children1.get(0), children2.get(0));
        }
        return (flipEquiv(children1.get(0), children2.get(0)) && flipEquiv(children1.get(1), children2.get(1))) || 
            (flipEquiv(children1.get(0), children2.get(1)) && flipEquiv(children1.get(1), children2.get(0)));
    }
}