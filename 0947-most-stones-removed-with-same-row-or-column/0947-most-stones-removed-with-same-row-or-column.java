class UnionFind{
    int [] parent;
    int size;
    int [] degree;
    public UnionFind(int n){
        parent = new int [n];
        degree = new int [n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        size = n;
    }
    public int find(int node){
        if(parent[node] == node) return node;
        return find(parent[node]);
    }
    public void union(int node1, int node2){
        int parent1 = find(node1);
        int parent2 = find(node2);
        if(parent1 == parent2){
            return;
        }
        if(degree[parent1]>degree[parent2]){
            parent[parent2] = parent1;
        }
        else if(degree[parent1]<degree[parent2]){
            parent[parent1] = parent2;
        }
        else{
            parent[parent1] = parent2;
            degree[parent2]++;
        }
        size--;
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(stones.length);
        for(int i = 0;i<stones.length;i++){
            for(int j = i+1;j<stones.length;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    uf.union(i, j);
                }
            }
        }
        return stones.length-uf.size;
    }
}