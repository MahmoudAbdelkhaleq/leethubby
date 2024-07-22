class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int [] rowOrder = topoSort(rowConditions, k);
        int [] colOrder = topoSort(colConditions, k);
        if(rowOrder.length == 0 || colOrder.length ==0){
            return new int [0][0];
        }
        int [][] result = new int [k][k];
        for(int i = 0; i<rowOrder.length;i++){
            for(int j= 0;j<colOrder.length;j++){
                if(rowOrder[i] == colOrder[j]){
                    result[i][j] = rowOrder[i];
                    break;
                }
            }
        }
        return result;
    }

    private int [] topoSort(int [][] edges, int n){
        List<Integer>[] map = new List[n+1];
        for(int i = 0;i<n+1;i++){
            map[i] = new ArrayList<>();
        }
        int [] inDegree = new int[n+1];
        int [] order = new int[n];
        for(int [] edge: edges){
            map[edge[0]].add(edge[1]);
        }
        for(int i = 0;i<n+1;i++){
            for(int v: map[i]){
                inDegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        int orderIndex = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            order[orderIndex++] = node;
            n--;
            List<Integer> neighbors = map[node];
            for(int neighbor: neighbors){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        if(n!=0) return new int [0];
        return order;
    }
}