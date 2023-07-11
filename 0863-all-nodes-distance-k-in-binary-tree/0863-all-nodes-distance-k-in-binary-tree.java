/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> nodes = new ArrayList<Integer>();
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        constructGraph(graph, root, null);
        List<Integer> visited = new ArrayList<Integer>();
        visited.add(target.val);
        helper(target.val, 0, k, nodes, visited, graph);
        return nodes;
    }
    private void constructGraph(HashMap<Integer, List<Integer>> graph, TreeNode node, TreeNode parent){
        if(node!=null && parent!=null){
            graph.computeIfAbsent(node.val, v->new ArrayList<Integer>()).add(parent.val);
            graph.computeIfAbsent(parent.val, v->new ArrayList<Integer>()).add(node.val);
        }
        if(node.left!=null){
            constructGraph(graph, node.left, node);
        }
        if(node.right!=null){
            constructGraph(graph, node.right, node);
        }
    }
    private void helper(int node, int dist, int k, List<Integer> nodes, List<Integer> visited, HashMap<Integer, List<Integer>> graph){
        if(dist == k){
            nodes.add(node);
            return;
        }
        for(int neighbor : graph.getOrDefault(node, new ArrayList<Integer>())){
            if(!visited.contains(neighbor)){
                visited.add(neighbor);
                helper(neighbor, dist+1, k, nodes, visited, graph);
            }
        }
    }
}