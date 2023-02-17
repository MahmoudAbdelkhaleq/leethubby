/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(root.val == p.val || root.val == q.val) return root;
        // if(root.left!=null)
        //     if(root.left.val == p.val || root.left.val == q.val)
        //         return 
        boolean findLeft = find(root.left,p,q);
        boolean findRight = find(root.right,p,q);
        if(!findLeft && !findRight) return root;
        if(findLeft) return lowestCommonAncestor(root.left,p,q);
        if(findRight) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
    public static boolean find(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        return findOne(root,p) && findOne(root,q);
    }
    public static boolean findOne(TreeNode root, TreeNode p){
        if(root == null) return false;
        if(root.val == p.val) return true;
        return findOne(root.left,p) || findOne(root.right,p);
    }
}