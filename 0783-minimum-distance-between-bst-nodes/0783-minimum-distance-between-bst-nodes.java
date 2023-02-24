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
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        arraytize(root, array);
        int min = Integer.MAX_VALUE;
        for(int i =0;i<array.size()-1;i++){
            int diff = array.get(i+1)-array.get(i);
            if(min>diff)min = diff;
        }
        return min;
    }
    public static void arraytize(TreeNode root, ArrayList<Integer> array){
        if(root == null) return;
        arraytize(root.left,array);
        array.add(root.val);
        arraytize(root.right,array);
    }
}