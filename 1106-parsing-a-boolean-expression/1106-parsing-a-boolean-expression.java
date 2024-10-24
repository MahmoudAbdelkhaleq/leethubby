class Solution {
    public boolean parseBoolExpr(String expression) {
        switch (expression.charAt(0)){
            case '&':
                return andEval(expression.substring(2,expression.length()-1));
            case '|':
                return orEval(expression.substring(2,expression.length()-1));
            default:
                return notEval(expression.substring(2,expression.length()-1));
        }
    }
    private boolean andEval(String inputs){
        boolean result = true;
        for(int i = 0;i<inputs.length() && result;i++){
            char c = inputs.charAt(i);
            switch(c){
                case 'f': result = false;
                    break;
                case 't':
                case ',': break;
                default : int end = getEnd(inputs, i+1);
                    result &= parseBoolExpr(inputs.substring(i, end+1));
                    i = end+1;
                    break;
            }
        }
        return result;
    }
    private boolean orEval(String inputs){
        boolean result = false;
        for(int i = 0;i<inputs.length() && !result;i++){
            char c = inputs.charAt(i);
            switch(c){
                case 't': result = true;
                    break;
                case 'f':
                case ',': break;
                default : int end = getEnd(inputs, i+1);
                    result |= parseBoolExpr(inputs.substring(i, end+1));
                    i = end+1;
                    break;
            }
        }
        return result;
    }

    private boolean notEval(String inputs){
        if(inputs.equals("t"))
            return false;
        if(inputs.equals("f"))
            return true;
        return !parseBoolExpr(inputs);
    }
    private int getEnd(String s, int index){
        int count = 0;
        for(int i = index;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
                continue;
            }
            if(c == ')'){
                count--;
            }
            if(count == 0){
                return i;
            }
        }
        return -1;
    }
}