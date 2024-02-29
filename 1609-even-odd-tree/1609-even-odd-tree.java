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
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int prev = -1;
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                if(prev == -1){
                    if(level%2==0 && node.val%2 == 0) return false;
                    if(level%2==1 && node.val%2 == 1) return false;
                }
                else{
                    if(level%2==0){
                        if(node.val%2==0 || node.val<=prev) return false;
                    }
                    else{
                        if(node.val%2==1 || node.val>=prev) return false;
                    }
                }
                prev = node.val;
            }
            level++;
        }
        return true;
    }
}