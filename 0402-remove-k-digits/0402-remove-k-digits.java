class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack  = new Stack<>();
        for(int i = 0;i<num.length();i++){
            while(!stack.isEmpty() && stack.peek()>num.charAt(i) && k>0){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            if(k==0){
                for(int j = i+1;j<num.length();j++){
                    stack.push(num.charAt(j));
                }
                break;
            }
        }
        while(!stack.isEmpty() && k>0){
                stack.pop();
                k--;
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
        }
        String s = res.toString();
        int i = 0;
        for(;i<s.length();i++){
            if(s.charAt(i)!='0')break;
        }
        if(i == s.length()) return "0";
        return s.substring(i,s.length());
    }
}