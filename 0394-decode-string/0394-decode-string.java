class Solution {
    public String decodeString(String s) {
        int startnum=0;
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)==']'){
                decode(stack);
            }
            else stack.push(s.charAt(i)+"");
        }
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
        }
        return res.toString();
    }
    private void decode(Stack<String> stack){
        StringBuilder res=new StringBuilder();
        while(!stack.isEmpty()){
            if(stack.peek().equals("[")){
                stack.pop();
                break;
            }
            res.insert(0,stack.pop());
        }
        StringBuilder num = new StringBuilder();
        while(!stack.isEmpty()){
            if(stack.peek().charAt(0)>='0' && stack.peek().charAt(0)<='9')
                num.insert(0,stack.pop());
            else break;
        }
        if((num.toString()).equals("")){
            stack.push(res.toString());
            return;
        }
        int number = Integer.parseInt(num.toString());
        StringBuilder result= new StringBuilder();
        for(int i =1;i<=number;i++)
            result.append(res);
        stack.push(result.toString());
    }
}