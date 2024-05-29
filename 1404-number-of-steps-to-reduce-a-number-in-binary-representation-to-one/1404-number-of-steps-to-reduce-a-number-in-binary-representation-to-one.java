class Solution {
    public int numSteps(String s) {
        StringBuilder string = new StringBuilder(s);
        int steps = 0;
        while(!string.toString().equals("1")){
            if(string.charAt(string.length()-1) == '0'){
                string = new StringBuilder(string.substring(0, string.length()-1));
            }
            else{
                int index = string.length()-1;
                while(index>-1 && string.charAt(index) == '1'){
                    string.setCharAt(index, '0');
                    index--;
                }
                if(index == -1){
                    string.insert(0, "1");
                }
                else{
                    string.setCharAt(index, '1');
                }
            }
            steps++;
        }
        return steps;
    }
}