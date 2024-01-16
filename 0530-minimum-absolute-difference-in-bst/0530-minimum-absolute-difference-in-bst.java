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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        add(root, order);
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<order.size();i++){
            int diff = order.get(i)-order.get(i-1);
            if(diff<min) min = diff;
        }
        return min;
    }
    void add(TreeNode node, List<Integer> order){
        if(node == null) return;
        add(node.left, order);
        order.add(node.val);
        add(node.right, order);
    }
}