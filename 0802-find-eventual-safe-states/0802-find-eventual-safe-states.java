class Solution {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        boolean [] safe = new boolean[graph.length];
        boolean [] notSafe = new boolean[graph.length];
        List<Integer> safeNodes = new ArrayList<Integer>();
        boolean [] isVisited = new boolean[graph.length];
        for(int i =0;i<graph.length;i++){
            if(checkSafety(i, graph, isVisited, safe, notSafe)){
                safeNodes.add(i);
            }
            isVisited = new boolean[graph.length];
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
    private static boolean checkSafety(int node, int[][] graph, boolean [] isVisited, boolean [] safe, boolean [] notSafe){
        if(safe[node]) return true;
        if(notSafe[node]) return false;
        int [] neighbors = graph[node];
        if(neighbors.length == 0){
            safe[node] = true;
            return true;
        }
        boolean allVisited = true;
        for(int i =0;i<neighbors.length;i++){
            allVisited = allVisited && isVisited[neighbors[i]];
        }
        if(allVisited){
            notSafe[node] = true;
            return false;
        }
        isVisited[node] = true;
        boolean isSafe = true;
        for(int i =0;i<neighbors.length;i++){
            if(safe[neighbors[i]]) continue;
            if(notSafe[neighbors[i]]){
                notSafe[node] = false;
                return false;
            }
            boolean [] newVisited = isVisited.clone();
            if(!isVisited[neighbors[i]]){
                isSafe = isSafe && checkSafety(neighbors[i], graph, newVisited, safe, notSafe);
                if(!isSafe) {
                    notSafe[node] = true;
                    return false;
                }
            }
            else{
                notSafe[node] = false;
                return false;
            }
        }
        if(isSafe) safe[node] = true;
        return isSafe;
    }
}