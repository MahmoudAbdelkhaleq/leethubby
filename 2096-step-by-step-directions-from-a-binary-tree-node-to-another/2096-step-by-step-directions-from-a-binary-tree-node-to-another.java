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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        find(root, startValue, startPath);
        StringBuilder destPath = new StringBuilder();
        find(root, destValue, destPath);
        StringBuilder res = new StringBuilder();
        int i = 0;
        for(;i<startPath.length() && i <destPath.length();i++){
            if(startPath.charAt(i)!=destPath.charAt(i)){
                break;
            }
        }
        for(int j = i;j<startPath.length();j++){
            res.append("U");
        }
        for(;i<destPath.length();i++){
            res.append(destPath.charAt(i));
        }
        return res.toString();
    }
    private boolean find(TreeNode node, int value, StringBuilder path){
        if(node == null){
            return false;
        }
        if(node.val == value){
            return true;
        }
        // check left
        path.append("L");
        if(find(node.left, value, path)){
            return true;
        }
        path.setLength(path.length() - 1); // Remove last character
        //check right
        path.append("R");
        if (find(node.right, value, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // Remove last character

        return false;
    }
}