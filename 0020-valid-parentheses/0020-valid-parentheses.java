import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack <Character>();
        for(int i =0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else{
                if(check(stack.peek(),s.charAt(i))){
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean check(char a, char b){
        if(a == '(' && b ==')') return true;
        if(a == '[' && b ==']') return true;
        if(a == '{' && b =='}') return true;
        return false;
    }
}