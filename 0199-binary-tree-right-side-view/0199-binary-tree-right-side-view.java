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
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> levelValue = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        list.add(root.val);
        helper(root.right, 1, levelValue);
        helper(root.left, 1, levelValue);
        for (Map.Entry<Integer, Integer> set :
             levelValue.entrySet()) {
                list.add(set.getValue());
        }
        return list;
    }
    public static void helper(TreeNode root, int level, HashMap<Integer, Integer> levelValue){
        if(root == null) return;
        if(!levelValue.containsKey(level)) levelValue.put(level,root.val);
        helper(root.right,level+1,levelValue);
        helper(root.left,level+1,levelValue);
    }
}