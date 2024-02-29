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
    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        Queue<TreeNode> level = new LinkedList<>();
        level.offer(root);
        while(!level.isEmpty()){
            int size=level.size();
            res = level.peek().val;
            for(int i = 0;i<size;i++){
                TreeNode node = level.poll();
                if(node.left!=null)
                    level.offer(node.left);
                if(node.right!=null)
                    level.offer(node.right);
            }
        }
        return res;
    }
}