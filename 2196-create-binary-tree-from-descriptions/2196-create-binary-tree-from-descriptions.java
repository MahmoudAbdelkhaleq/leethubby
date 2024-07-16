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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, Integer[]> map = new HashMap<>();
        HashSet<Integer> nodes = new HashSet<>();
        for(int [] des: descriptions){
            Integer [] children = map.getOrDefault(des[0], new Integer[]{0,0});
            des[2] = des[2] == 0? 1:0;
            children[des[2]] = des[1];
            map.put(des[0], children);
            nodes.add(des[1]);
        }
        int root = 0;
        for(int [] des : descriptions){
            if(!nodes.contains(des[0])){
                root = des[0];
                break;
            }
        }
        return generateTree(root, map);
    }
    private TreeNode generateTree(int val, HashMap<Integer, Integer[]> map){
        if(val == 0){
            return null;
        }
        Integer[] children = map.get(val);
        if(children==null){
            return new TreeNode(val);
        }
        TreeNode leftTree = generateTree(children[0], map);
        TreeNode rightTree = generateTree(children[1],map);
        TreeNode tree = new TreeNode(val, leftTree, rightTree);
        return tree;
    }
}