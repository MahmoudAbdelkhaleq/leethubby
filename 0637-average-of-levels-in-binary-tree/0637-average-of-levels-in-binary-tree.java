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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty()){
            int newCount = 0;
            long sum = 0;
            int n = count;
            while(count>0){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                    newCount++;
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    newCount++;
                }
                count--;
            }
            res.add(sum/(n+0.0));
            count = newCount;
        }
        return res;
    }
}