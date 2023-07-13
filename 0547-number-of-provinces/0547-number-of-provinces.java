class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i =0;i<isConnected.length;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i =0;i<isConnected.length;i++){
            for(int j =0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1 && i!=j)
                    graph.get(i).add(j);
            }
        }
        boolean [] isVisited = new boolean[graph.size()];
        int count = 0;
        for(int i =0;i<graph.size();i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                discover(graph, i, isVisited);
                count ++;
            }
        }
        return count;
    }
    private static void discover(ArrayList<ArrayList<Integer>> graph, int node, boolean [] isVisited){
        ArrayList<Integer> neighbors = graph.get(node);
        for(int i =0;i<neighbors.size();i++){
            if(!isVisited[neighbors.get(i)]){
                isVisited[neighbors.get(i)] = true;
                discover(graph, neighbors.get(i), isVisited);
            }
        }
    }
}