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
            dfs(root, new HashMap<>(), res);
            return res[0];
        }
        private void dfs(TreeNode node, HashMap<Integer, Integer> map, int [] res){
            if(node == null) return;
            if(node.left == null && node.right == null){
                map.put(node.val, map.getOrDefault(node.val, 0)+1);
                if(palindrome(map)) res[0]++;
                map.put(node.val, map.get(node.val)-1);
                return;
            }
            map.put(node.val, map.getOrDefault(node.val, 0)+1);
            dfs(node.left, map, res);
            dfs(node.right, map, res);
            map.put(node.val, map.get(node.val)-1);
            
        }
        private boolean palindrome(HashMap<Integer, Integer> map){
            boolean theOne = false;
            for(int x:map.values()){
                if(x%2!=0){
                    if(theOne) return false;
                    else theOne = true;
                }
            }
            return true;
        }
}