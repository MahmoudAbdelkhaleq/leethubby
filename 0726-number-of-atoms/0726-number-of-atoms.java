class Solution {
        public String countOfAtoms(String formula) {
        Set<String> elements = new HashSet<>();
        Stack<TreeMap<String, Integer>> stack = new Stack();
        // stack.push(new HashMap<>());
        reformulate(formula, 0, elements, stack);
        StringBuilder res = new StringBuilder();
        TreeMap<String, Integer> data = stack.pop();
        for(String element: data.keySet()){
            res.append(element);
            if(data.get(element)>1){
                res.append(data.get(element));
            }
        }
        return res.toString();
    }
    private int reformulate(String formula, int index, Set<String> elements, Stack<TreeMap<String, Integer>> stack){

        TreeMap<String, Integer> currentData = new TreeMap<>();
        stack.push(currentData);
        int i = index;
        String element = "";
        String number = "1";
        while(i<formula.length()){
            char c = formula.charAt(i);
            // get element
            if(isUpperCase(c)){
                element = c+"";
                i++;
                while (i < formula.length() && isLowerCase(formula.charAt(i))) {
                    element += formula.charAt(i++);
                }
                elements.add(element);
                // get number
                if(i<formula.length() && isDigit(formula.charAt(i))){
                    number = "";
                    while(i<formula.length() && isDigit(formula.charAt(i))){
                        number+=formula.charAt(i++);
                    }
                }
                currentData.put(element, currentData.getOrDefault(element, 0) + Integer.parseInt(number));
                number = "1";
            }
            else{
                // case of brackets
                if(c == '('){
                    i = reformulate(formula, i+1, elements, stack);
                }
                else{
                    // get the number multiplied by the bracket
                    i++;
                    if(i<formula.length() && isDigit(formula.charAt(i))){
                        number = "";
                        while(i<formula.length() && isDigit(formula.charAt(i))){
                            number+=formula.charAt(i++);
                        }
                    }
                    // multiply by the number
                    for(String s:currentData.keySet()){
                        currentData.put(s, currentData.get(s)*Integer.parseInt(number));
                    }
                    // remove from top
                    stack.pop();
                    //merge two hashmaps
                    merge(stack.peek(),currentData);
                    return i;
                }
            }
        }
        return i;
    }
    private void merge(TreeMap<String, Integer> top, TreeMap<String, Integer> current){
        for(String s: current.keySet()){
            top.put(s, top.getOrDefault(s,0)+current.get(s));
        }
    }
    private boolean isDigit(char c){
        return c>='0' && c<='9';
    }
    private boolean isLowerCase(char c){
        return c>='a' && c<='z';
    }
    private boolean isUpperCase(char c){
        return c>='A' && c<='Z';
    }
}