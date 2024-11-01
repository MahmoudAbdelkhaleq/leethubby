class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        int count = 1;
        char c = s.charAt(0);
        res.append(c);
        for(int i = 1;i<s.length();i++){
            if(c == s.charAt(i)){
                count++;
            }
            else{
                count = 1;
                c = s.charAt(i);
            }
            if(count<3){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}