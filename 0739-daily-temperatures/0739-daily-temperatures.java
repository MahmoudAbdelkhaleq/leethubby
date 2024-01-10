class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack <Integer> indices = new Stack<>();
        int [] res = new int [temperatures.length];
        for(int i = 0;i<temperatures.length;i++){
            while(!indices.isEmpty()){
                if(temperatures[i]>temperatures[indices.peek()]){
                    res[indices.peek()] = i-indices.pop(); 
                }
                else break;
            }
            indices.push(i);
        }
        while(!indices.isEmpty()){
            res[indices.pop()] = 0; 
        }
        return res;
    }
}