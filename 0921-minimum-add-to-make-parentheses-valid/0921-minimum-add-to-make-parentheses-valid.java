class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for(char c: s.toCharArray()){
            if(!brackets.isEmpty() && c == ')' && brackets.peek() == '('){
                brackets.pop();
            }
            else{
                brackets.push(c);
            }
        }
        return brackets.size();
    }
}