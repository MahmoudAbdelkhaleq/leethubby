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
    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer> sums = new ArrayList<Integer>();
        helper(root, sums, 0);
        int maxLevel = -1;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<sums.size();i++){
            if(max<sums.get(i)){
                max = sums.get(i);
                maxLevel = i+1;
            }
        }
        return maxLevel;
    }
    public static void helper(TreeNode root, ArrayList<Integer> sums, int level){
        if(root == null) return;
        if(sums.size()<level+1){
            sums.add(root.val);
        }
        else{
            sums.set(level, sums.get(level)+root.val);
        }
        helper(root.left, sums, level+1);
        helper(root.right, sums, level+1);
    }
}