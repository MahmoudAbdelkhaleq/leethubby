class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {

        DisjointSet aliceGraph = new DisjointSet(n);
        DisjointSet bobGraph = new DisjointSet(n);
        Arrays.sort(edges, (a,b) -> (b[0]-a[0]));

        int adddedEdges = 0;

        for(int[] e: edges) {
            int type = e[0];
            int u = e[1]-1;
            int v = e[2]-1;

            if (type == 3) {
                boolean isAliceConnected = aliceGraph.unionByRank(u,v);
                boolean isBobConnected = bobGraph.unionByRank(u,v);
                if (isAliceConnected  || isBobConnected) {

                    adddedEdges++;
                }
            }
            else if (type == 2) {


                 boolean isBobConnected = bobGraph.unionByRank(u,v);

                System.out.println( isBobConnected );

                 if (isBobConnected ) {
                    adddedEdges++;
                }
                
            }
            else if (type == 1) {
                boolean isAliceConnected = aliceGraph.unionByRank(u,v);
                System.out.println( isAliceConnected );

                 if (isAliceConnected) {
                    adddedEdges++;
                }
            }
        }



        if (aliceGraph.count > 1 || bobGraph.count > 1) return -1;
        return edges.length - adddedEdges;
    }

}


class DisjointSet{
    
    int[] parent;
    int[] rank;
    int count;

    DisjointSet(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i=0;i<n;++i) {
            parent[i] = i;
            rank[i] = 0;
        }
        this.count = n;
    }

    public int ultimateParent(int v){
        if (parent[v]!=v) {
            parent[v] = ultimateParent(parent[v]);
        }
        return parent[v];
    }

    public boolean isConnected(int u, int v) {
        return ultimateParent(u) == ultimateParent(v);
    }

    public boolean unionByRank(int u, int v) {
        int ulp_u = ultimateParent(u);
        int ulp_v = ultimateParent(v);

        if (ulp_u == ulp_v) return false;
        
        if (rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = ulp_u;
        } else if (rank[ulp_v] > rank[ulp_u]) {
            parent[ulp_u] = ulp_v;
        } else{
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        }
        count--;
        return true;
    }
}