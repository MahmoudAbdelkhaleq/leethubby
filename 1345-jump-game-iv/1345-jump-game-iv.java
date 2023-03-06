class Solution {
    public int minJumps(int[] arr) {
        boolean [] visited = new boolean[arr.length];
        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        HashMap<Integer, ArrayList<Integer>> positions = new HashMap<Integer, ArrayList<Integer>>();
        for(int i =0;i<arr.length;i++){
            ArrayList<Integer> current;
            if(positions.containsKey(arr[i])){
                current = positions.get(arr[i]);
                current.add(i);
            }
            else{
                current = new ArrayList<Integer>();
                current.add(i);
                positions.put(arr[i],current);
            }
        }
        Integer [] initial = {0,0};
        queue.offer(initial);
        visited[0]=true;
        return helper(arr, visited, queue, positions);
    }
    public static int helper(int [] arr, boolean [] visited, Queue<Integer[]> queue, HashMap<Integer, ArrayList<Integer>> positions){
        Integer [] state = queue.poll();
        int index = state[0];
        int count = state[1];
        if(index == arr.length-1) return count;
        if(index>0 && !visited[index-1]){
            Integer [] newState= {index-1,count+1};
            queue.add(newState);
            visited[index-1]=true;
        }
        if(index<arr.length-1 && !visited[index+1]){
            Integer [] newState= {index+1,count+1};
            queue.add(newState);
            visited[index+1]=true;
        }
        ArrayList<Integer> numPos = positions.get(arr[index]);
        if(arr.length/positions.size()>10){
            int newIndex = numPos.get(numPos.size()-1);
            Integer [] newState= {newIndex,count+1};
            queue.add(newState);
            visited[newIndex]=true;
        }
        else{
            for(int i =numPos.size()-1;i>-1;i--){
                int newIndex=numPos.get(i);
                if(newIndex!=index-1 && newIndex!=index+1 && !visited[newIndex]){
                    Integer [] newState= {newIndex,count+1};
                    queue.add(newState);
                    visited[newIndex]=true;
                }
            }
        }
        return helper(arr,visited,queue,positions);
    }
}