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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty()){
            int newCount = 0;
            long levelSum = 0;
            while(count>0){
                TreeNode node = queue.poll();
                count--;
                if(node.left!=null){
                    queue.offer(node.left);
                    newCount++;
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    newCount++;
                }
                levelSum+=node.val;
            }
            pq.offer(levelSum);
            count = newCount;
        }
        while(k>1 && !pq.isEmpty()){
            pq.poll();
            k--;
        }
        return pq.isEmpty() ? -1 : pq.poll();
    }
}