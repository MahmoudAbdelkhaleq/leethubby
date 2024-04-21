class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        boolean [] isVisited = new boolean [n];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int [] edge:edges){
            map.computeIfAbsent(edge[0], v->new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], v->new HashSet<>()).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        isVisited[source] = true;
        while(!queue.isEmpty()){
            int src = queue.poll();
            Set<Integer> dests = map.get(src);
            if(dests == null) continue;
            for(int dest:dests){
                if(!isVisited[dest]){
                    if(dest == destination) return true;
                    queue.offer(dest);
                    isVisited[dest] = true;
                }
            }
        }
        return false;
    }
}