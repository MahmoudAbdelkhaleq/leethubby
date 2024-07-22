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
class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        postOrder(root, distance, new ArrayList<>());
        return count;
    }
    public void postOrder(TreeNode node, int distance, List<Pair>leaves){
        if(node == null){
            return;
        }
        if(node.left==null && node.right == null){
            leaves.add(new Pair(1,1));
            return;
        }
        List<Pair> leftLeaves = new ArrayList<>();
        List<Pair> rightLeaves = new ArrayList<>();
        postOrder(node.left, distance, leftLeaves);
        postOrder(node.right, distance, rightLeaves);
        for(int i= 0;i<leftLeaves.size() && leftLeaves.get(i).x<distance;i++){
            Pair first = leftLeaves.get(i);
            for(int j = 0; j<rightLeaves.size();j++){
                Pair second = rightLeaves.get(j);
                if(first.x+second.x<= distance){
                    count+=first.y*second.y;
                }
                else{
                    break;
                }
            }
        }
        int i = 0;
        int j = 0;
        while(i<leftLeaves.size() && j< rightLeaves.size()){
            Pair first = leftLeaves.get(i);
            Pair second = rightLeaves.get(j);
            if(first.x>=distance || second.x >= distance){
                break;
            }
            if(first.x == second.x){
                first.y+=second.y;
                first.x++;
                leaves.add(first);
                j++;
                i++;
            }
            else{
                if(first.x>second.x){
                    second = new Pair(second.x+1, second.y);
                    leaves.add(second);
                    j++;
                }
                else{
                    first = new Pair(first.x+1, first.y);
                    leaves.add(first);
                    i++;
                }
            }
        }
        while (i<leftLeaves.size() && leftLeaves.get(i).x<distance){
            Pair first = leftLeaves.get(i);
            if(first.x<distance){
                first = new Pair(first.x+1, first.y);
                leaves.add(first);
            }
            else{
                break;
            }
            i++;
        }
        while(j<rightLeaves.size() && rightLeaves.get(j).x<distance){
            Pair second = rightLeaves.get(j);
            if(second.x<distance){
                second = new Pair(second.x+1, second.y);
                leaves.add(second);
            }
            else{
                break;
            }
            j++;
        }
        Collections.sort(leaves, new Comparator<>(){
            public int compare(Pair p1, Pair p2){
                return p1.x-p2.x;
            }
        });
    }
}