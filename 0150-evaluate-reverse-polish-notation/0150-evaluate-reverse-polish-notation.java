class Solution {
    public int evalRPN(String[] tokens) {
        Stack <String> stack = new Stack<String>();
        int result = 0;
        for(int i = 0; i<tokens.length;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/"))
                stack.push(tokens[i]);
            else{
                int x = Integer.parseInt(stack.pop());
                int y = Integer.parseInt(stack.pop());
                switch(tokens[i]){
                        case "+":result = y + x;break;
                        case "-":result = y - x;break;
                        case "*":result = y * x;break;
                        case "/":result = y / x;break;
                }
                stack.push(result+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}