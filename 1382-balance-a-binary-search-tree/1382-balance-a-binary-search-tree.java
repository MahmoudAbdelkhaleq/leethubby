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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> order = new ArrayList<Integer>();
        sort(root,order);
        Integer [] sortedTree = order.toArray(new Integer[0]);
        int start = 0;
        int end = sortedTree.length-1;
        return constructTree(sortedTree, start, end);
    }
    public TreeNode constructTree(Integer [] sortedTree, int start, int end){
        if(start>end)
            return null;
        int mid = (end-start)/2 + start;
        
        return new TreeNode(sortedTree[mid], 
                constructTree(sortedTree, start, mid-1),
                constructTree(sortedTree, mid+1, end));
    }
    public void sort(TreeNode node, List<Integer> order){
        if(node == null)
            return;
        sort(node.left, order);
        order.add(node.val);
        sort(node.right, order);
    }
}