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
    public int amountOfTime(TreeNode root, int start) {
        if(root == null) return 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int res = -1;
        helper(root, map, null);
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        int oldCount = 1;
        while(!q.isEmpty()){
            int count = 0;
            while(oldCount>0){
                List<Integer> l = map.get(q.poll());
                for(int i = 0;i<l.size();i++){
                    if(!visited.contains(l.get(i))){
                        q.offer(l.get(i));
                        visited.add(l.get(i));
                        count++;
                    }
                }
                oldCount--;
            }
            oldCount = count;
            res++;
        }
        return res;
    }
    private void helper(TreeNode node, HashMap<Integer, List<Integer>> map, TreeNode parent){
        if(node == null) return;
        List<Integer> l = new ArrayList<>();
        if(node.left!=null)l.add(node.left.val);
        if(node.right!=null)l.add(node.right.val);
        if(parent!=null)l.add(parent.val);
        map.put(node.val,l);
        helper(node.left, map, node);
        helper(node.right, map, node);
    }
}