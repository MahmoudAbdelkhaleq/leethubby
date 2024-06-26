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
        int mid = (end-start)/2 + start;
        TreeNode res = new TreeNode(sortedTree[mid]);
        constructTree(res, sortedTree, start, mid-1);
        constructTree(res, sortedTree, mid+1, end);
        return res;
    }
    public void constructTree(TreeNode root, Integer [] sortedTree, int start, int end){
        if(start>end)
            return;
        int mid = (end-start)/2 + start;
        insert(root, sortedTree[mid]);
        constructTree(root, sortedTree, start, mid-1);
        constructTree(root, sortedTree, mid+1, end);
    }
    public void sort(TreeNode node, List<Integer> order){
        if(node == null)
            return;
        sort(node.left, order);
        order.add(node.val);
        sort(node.right, order);
    }
    public void insert(TreeNode root, int val){
        TreeNode parent = null;
        TreeNode current = root;
        while(current!=null){
            parent = current;
            if(current.val > val){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        if(parent.val > val){
            parent.left = new TreeNode(val);
        }
        else {
            parent.right = new TreeNode(val);
        }
    }
}