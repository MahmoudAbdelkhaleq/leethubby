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
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty()){
            int newCount = 0;
            int sum = 0;
            while(count>0){
                TreeNode node = queue.poll();
                count--;
                sum+=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                    newCount++;
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    newCount++;
                }
            }
            levelSum.add(sum);
            count = newCount;
        }
        replace(root, levelSum, 0, 0);
        return root;
    }
    private void replace(TreeNode node, List<Integer> levelSum, int level, int brother){
        if(node == null){
            return;
        }
        node.val = levelSum.get(level)-node.val-brother;
        int leftBrother = node.left == null ? 0 : node.left.val;
        int rightBrother = node.right == null ? 0 : node.right.val;
        replace(node.left, levelSum, level+1, rightBrother);
        replace(node.right, levelSum, level+1, leftBrother);
    }
}