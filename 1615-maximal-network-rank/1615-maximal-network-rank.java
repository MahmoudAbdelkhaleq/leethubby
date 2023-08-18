class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i =0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i =0;i<roads.length;i++){
            map.get(roads[i][0]).add(roads[i][1]);
            map.get(roads[i][1]).add(roads[i][0]);
        }
        int max = 0;
        for(int i =0;i<n;i++){
            for(int j =i+1;j<n;j++){
                int networkRank = map.get(i).size()+map.get(j).size();
                if(map.get(i).contains(j))networkRank--;
                if(networkRank>max)max = networkRank;
            }
        }
        return max;
    }
}