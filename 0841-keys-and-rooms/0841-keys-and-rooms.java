class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] isVisited = new boolean[rooms.size()];
        dfs(rooms, isVisited, 0);
        return allVisited(isVisited);
    }
    private void dfs(List<List<Integer>> rooms, boolean[]isVisited, int index){
        List<Integer> keys = rooms.get(index);
        isVisited[index] =true;
        for(Integer key: keys){
            if(!isVisited[key]) dfs(rooms, isVisited, key);
        }
    } 
    private boolean allVisited(boolean [] isVisited){
        for(int i =0;i<isVisited.length;i++){
            if(!isVisited[i])return false;
        }
        return true;
    }
}