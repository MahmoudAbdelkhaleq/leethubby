class Solution {
    public int maximumGain(String s, int x, int y) {
        String higher = x>y? "ab":"ba";
        int higherScore = x>y?x:y;
        int lowerScore = x>y?y:x;
        int score = 0;
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }
            else{
                if(higher.equals(stack.peek()+""+c)){
                    stack.pop();
                    score+=higherScore;
                }
                else{
                    stack.push(c);
                }
            }
        }
        Stack <Character> stack2 = new Stack<>();
        if(!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        while(!stack.isEmpty()){
            char c1 = stack.pop();
            char c2 = stack2.pop();
            if(higher.equals(c2+""+c1)){
                score+=lowerScore;
                if(!stack.isEmpty() && stack2.isEmpty()){
                    stack2.push(stack.pop());
                }
            }
            else{
                stack2.push(c2);
                stack2.push(c1);
            }
        }
        return score;
    }
}