class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind aliceMap = new UnionFind(n);
        UnionFind bobMap = new UnionFind(n);
        Arrays.sort(edges, (a,b)->(b[0]-a[0]));
        int addedEdges = 0;
        for(int [] edge: edges){
            int type = edge[0];
            int u = edge[1]-1;
            int v = edge[2]-1;
            if(type == 3){
                if(aliceMap.union(u, v)){
                    bobMap.union(u, v);
                    addedEdges++;
                }
            }
            else if(type == 1){
                if(aliceMap.union(u, v)){
                    addedEdges++;
                }
            }
            else{
                if(bobMap.union(u, v)){
                    addedEdges++;
                }
            }
            if(aliceMap.numOfGroups() == 1 && bobMap.numOfGroups() == 1){
                return edges.length-addedEdges;
            }
        }
        return -1;
    }
}
class UnionFind {
    // parent for every node
    int [] parent;
    // size of each group
    int [] size;
    // no of groups
    int count;
    public UnionFind(int n){
        parent = new int[n];
        size = new int [n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 0;
        }
        count = n;
    }
    public int numOfGroups(){
        return count;
    }
    public int getParent(int node){
        if(parent[node] == node){
            return node;
        }
        return getParent(parent[node]);
    }
    public boolean union(int node1, int node2){
        int n1Parent = getParent(node1);
        int n2Parent = getParent(node2);
        if(n1Parent == n2Parent){
            return false;
        }
        if(size[n1Parent]>size[n2Parent]){
            parent[n2Parent] = n1Parent;
        }
        else if(size[n2Parent] > size[n1Parent]){
            parent[n1Parent] = n2Parent;
        }
        else{
            parent[n1Parent] = n2Parent;
            size[n2Parent]++;
        }
        count--;
        return true;
    }
}