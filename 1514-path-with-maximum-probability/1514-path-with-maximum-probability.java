class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer, List<Double[]>> map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int [] edge = edges[i];
            map.computeIfAbsent(edge[0], k-> new ArrayList<>()).add(new Double[]{edge[1]+0.0, succProb[i]});
            map.computeIfAbsent(edge[1], k-> new ArrayList<>()).add(new Double[]{edge[0]+0.0, succProb[i]});
        }
        PriorityQueue<Double []> pq = new PriorityQueue<>(new Comparator<Double[]>(){
            @Override
            public int compare(Double [] d1, Double [] d2){
                return Double.compare(d2[1],d1[1]);
            }
        });
        pq.offer(new Double[]{start_node+0.0, 1.0});
        double [] probs = new double[n];
        probs[start_node] = 1.0;
        while(!pq.isEmpty()){
            Double [] state = pq.poll();
            List<Double[]> neighbors = map.get(state[0].intValue());
            Double prob = state[1];
            if(state[0].intValue() == end_node){
                return prob;
            }
            if(neighbors==null){
                continue;
            }
            for(Double[] neighbor: neighbors){
                if(neighbor[1]*prob>probs[neighbor[0].intValue()]){
                    probs[neighbor[0].intValue()] = neighbor[1]*prob;
                    pq.offer(new Double[]{neighbor[0],neighbor[1]*prob});
                }
            }
        }
        return probs[end_node];
    }
}