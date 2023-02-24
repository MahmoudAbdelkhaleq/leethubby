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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traverse = new ArrayList<List<Integer>>();
        traverseLevels(root,traverse,0);
        return traverse;
    }
    public static void traverseLevels(TreeNode root, List<List<Integer>> traverse, int level){
        if(root == null) return;
        if(traverse.size()<level+1) traverse.add(new ArrayList<Integer>());
        List<Integer> x = traverse.get(level);
        x.add(root.val);
        traverseLevels(root.left,traverse,level+1);traverseLevels(root.right,traverse,level+1);
    }
}