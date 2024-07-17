class Solution {
    public int maximumGain(String s, int x, int y) {
        String higher = x>y? "ab":"ba";
        String lower = higher.equals("ba")? "ab":"ba";
        int higherScore = x>y?x:y;
        int lowerScore = x>y?y:x;
        int score = 0;
        Stack<Character> stack = new Stack<>();
        score+=removePair(s, higher, higherScore, stack);
        StringBuilder remaining = new StringBuilder();
        while(!stack.isEmpty()){
            remaining.insert(0,stack.pop());
        }
        s = remaining.toString();
        score+=removePair(s, lower, lowerScore, stack);
        return score;
    }
    private int removePair(String s, String pair, int pairScore, Stack<Character> stack){
        int score = 0;
        for(char c:s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }
            else{
                if(pair.equals(stack.peek()+""+c)){
                    stack.pop();
                    score+=pairScore;
                }
                else{
                    stack.push(c);
                }
            }
        }
        return score;
    }
}