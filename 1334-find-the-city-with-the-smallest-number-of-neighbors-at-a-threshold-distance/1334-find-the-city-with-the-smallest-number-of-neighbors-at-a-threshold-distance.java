class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        long [][] dist = new long[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for(int i = 0;i<n;i++){
            dist[i][i] = 0;
        }
        for(int [] edge:edges){
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(dist[i][j]>dist[i][k]+dist[k][j]){
                        dist[i][j] = dist[i][k]+dist[k][j];
                        dist[j][i] = dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        int city = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            int count = 0;
            for(int j = 0;j<n;j++){
                if(dist[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=min){
                min = count;
                city = i;
            }
        }
        return city;
    }
}