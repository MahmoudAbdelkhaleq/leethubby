import java.util.*;

class Weight{
    double weight;
    String destination;
    public Weight(double weight, String destination){
        this.weight = weight;
        this.destination = destination;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double [] res = new double[queries.size()];
        HashMap<String, List<Weight>> map = new HashMap<>();
        for(int i =0;i< equations.size();i++){
            map.computeIfAbsent(equations.get(i).get(0), k-> new ArrayList<>()).add(new Weight(values[i],equations.get(i).get(1)));
            map.computeIfAbsent(equations.get(i).get(1), k-> new ArrayList<>()).add(new Weight(1.0/values[i],equations.get(i).get(0)));
        }
        for(int i =0;i<queries.size();i++){
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), map);
        }
        return res;
    }
    public static double dfs(String up, String down, HashMap<String, List<Weight>> map){
        if(!map.containsKey(up) || !map.containsKey(down)) return -1;
        if(up.equals(down))return 1.0;
        Queue<Weight> queue = new LinkedList<>();
        Queue<String> strings = new LinkedList<>();
        List<Weight> neighbors = map.get(up);
        for(Weight neighbor:neighbors){
            if(down.equals(neighbor.destination)) return neighbor.weight;
            queue.add(neighbor);
            strings.add(up + "." +neighbor.destination+".");
        }
        while (!queue.isEmpty()){
            Weight current = queue.poll();
            String string = strings.poll();
            if(down.equals(current.destination)) return current.weight;
            else{
                for(Weight neighbor: map.get(current.destination)){
                    if(!string.contains("."+neighbor.destination+".")){
                        queue.offer(new Weight(neighbor.weight*current.weight, neighbor.destination));
                        strings.offer(string + "." + neighbor.destination);
                    }
                }
            }
        }
        return -1;
    }
}