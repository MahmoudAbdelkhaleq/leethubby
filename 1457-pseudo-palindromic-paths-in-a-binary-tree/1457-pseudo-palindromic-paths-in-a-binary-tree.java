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
    public int pseudoPalindromicPaths (TreeNode root) {
            int [] res = new int [1];
            dfs(root, new int[10], res);
            return res[0];
        }
        private void dfs(TreeNode node, int [] freq, int [] res){
            if(node == null) return;
            if(node.left == null && node.right == null){
                freq[node.val]++;
                if(palindrome(freq)) res[0]++;
                freq[node.val]--;
                return;
            }
            freq[node.val]++;
            dfs(node.left, freq, res);
            dfs(node.right, freq, res);
            freq[node.val]--;
            
        }
        private boolean palindrome(int[] freq){
            boolean theOne = false;
            for(int x:freq){
                if(x%2!=0){
                    if(theOne) return false;
                    else theOne = true;
                }
            }
            return true;
        }
}