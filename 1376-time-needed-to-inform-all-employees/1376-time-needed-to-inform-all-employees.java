class Solution {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer> times = new ArrayList<Integer>();
        for(int i =0;i<manager.length;i++){
            if(manager[i]!=-1){
                if(map.get(manager[i])!=null)
                    map.get(manager[i]).add(i);
                else{
                    ArrayList<Integer> x = new ArrayList<Integer>();
                    x.add(i);
                    map.put(manager[i],x);
                }
            }
        }
        helper(headID, informTime, 0, times);
        return Collections.max(times);
    }
    private void helper(int headID, int[] informTime, int time, ArrayList<Integer> list){
        ArrayList<Integer> children = map.get(headID);
        if(children == null){
            list.add(time);
            return;
        }
        for(int i =0;i<children.size();i++){
            helper(children.get(i), informTime, time + informTime[headID], list);
        }
    }
}