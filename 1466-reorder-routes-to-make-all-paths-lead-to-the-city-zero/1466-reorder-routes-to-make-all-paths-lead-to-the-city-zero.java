class Solution {
    int count = 0;
    boolean [] isVisited;
    HashMap<Integer, List<Integer>> map1;
    HashMap<Integer, List<Integer>> map2;
    public int minReorder(int n, int[][] connections) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        for(int i =0;i<n;i++){
            map1.put(i, new ArrayList<>());
            map2.put(i, new ArrayList<>());
        }
        for(int i =0;i<connections.length;i++){
            map1.get(connections[i][0]).add(connections[i][1]);
            map2.get(connections[i][1]).add(connections[i][0]);
        }
        isVisited = new boolean[n];
        dfs(0);
        return count;
    }
    public void dfs(int node){
        isVisited[node] = true;
        List<Integer> forward = map1.get(node);
        List<Integer> backward = map2.get(node);
        for(int i =0;i<forward.size();i++){
            if(!isVisited[forward.get(i)]){
                count++;
                dfs(forward.get(i));
            }
        }
        for(int i =0;i<backward.size();i++){
            if(!isVisited[backward.get(i)])
                dfs(backward.get(i));
        }
    }
}