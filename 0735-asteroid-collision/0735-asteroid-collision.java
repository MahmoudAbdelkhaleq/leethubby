class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0;i<asteroids.length;i++){
            if(s.isEmpty()){
                s.push(asteroids[i]);
                continue;
            }
            if(asteroids[i]<0 && s.peek()>0){
                if(asteroids[i] == -1*s.peek()){
                    s.pop();
                }
                else if(Math.abs(asteroids[i])>Math.abs(s.peek())){
                    s.pop();
                    i--;
                }
            }
            else{
                s.push(asteroids[i]);
            }
        }
        int [] res = new int[s.size()];
        int index = s.size()-1;
        while(!s.isEmpty()){
            res[index--] = s.pop();
        }
        return res;
    }
}