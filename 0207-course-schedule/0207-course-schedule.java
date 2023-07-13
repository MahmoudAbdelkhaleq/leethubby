class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i =0;i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i =0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return hasCycle(numCourses, graph);
    }
    private boolean hasCycle(int numCourses, ArrayList<ArrayList<Integer>> graph){
        int [] indegree = new int [numCourses];
        for(int i =0;i<numCourses;i++){
            for(int j = 0;j<graph.size();j++){
                if(graph.get(j).contains(i)) indegree[i]++;
            }
        }
        boolean finish = false;
        while(!finish){
            for(int i =0;i<indegree.length;i++){
                ArrayList<Integer> neighbors = graph.get(i);
                if(indegree[i]==0 && neighbors.size()>0){
                    for(int j =0;j<neighbors.size();j++){
                        indegree[neighbors.get(j)]--;
                    }
                    graph.set(i, new ArrayList<Integer>());
                }
            }
            finish = true;
            for(int i =0;i<indegree.length;i++){
                if(indegree[i]==0){
                    if(graph.get(i).size()>0){
                        finish = false;
                        break;
                    }
                }
            }
        }
        if(zeroInDegree(indegree)) return true;
        return false;
    }
    private boolean zeroInDegree(int [] indegree){
        for(int i =0;i<indegree.length;i++)
            if(indegree[i]!=0)
                return false;
        return true;
    }
}