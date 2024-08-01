class State{
    int node;
    int time;
    public State(int node, int time){
        this.node=node;
        this.time=time;
    }
}
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        int first = -1;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int [] edge: edges){
            map.computeIfAbsent(edge[0], k-> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k-> new ArrayList<>()).add(edge[0]);
        }
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(1,0));
        int [] d1 = new int [n+1];
        int [] d2 = new int [n+1];
        Arrays.fill(d1, -1);
        Arrays.fill(d2, -1);
        while(!queue.isEmpty()){
            State current = queue.poll();
            List<Integer> neighbors = map.get(current.node);
            int currentTime = current.time;
            boolean red = (currentTime/change)%2 == 1;
            if(red){
                currentTime-=(currentTime%change);
                currentTime+=change;
            }
            currentTime+=time;
            for(int node:neighbors){
                if(d1[node] == -1){
                    d1[node] = currentTime;
                    queue.offer(new State(node, currentTime));
                }
                else if(d2[node] == -1 && currentTime>d1[node]){
                    if(node == n){
                        return currentTime;
                    }
                    d2[node] = currentTime;
                    queue.offer(new State(node, currentTime));
                }
            }
        }
        return 0;
    }
}