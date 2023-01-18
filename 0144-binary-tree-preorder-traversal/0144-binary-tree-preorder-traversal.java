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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<Integer>();
        if(root == null) return order;
        String result = helper(root);
        result = result.substring(1,result.length());
        String [] nodes = result.split(",");
        for(int i =0;i<nodes.length;i++) order.add(Integer.parseInt(nodes[i]));
        return order;
    }
    public static String helper(TreeNode root){
        if(root == null) return "";
        return ","+root.val+helper(root.left)+helper(root.right);
    }
}