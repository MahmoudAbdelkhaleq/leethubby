class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        Set<Character> chars = new HashSet();
        boolean cond = false;
        if(s.equals(goal)){
            for(int i =0;i<s.length();i++){
                if(chars.contains(s.charAt(i))) return true;
                chars.add(s.charAt(i));
            }
        }
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)!=goal.charAt(i)){
                if(!cond){
                    for(int j =i+1;j<s.length();j++){
                        if(s.charAt(j)==goal.charAt(i) && s.charAt(i)==goal.charAt(j)){
                            cond=true;
                            i=j;
                            break;
                        }
                        if(s.charAt(j)!=goal.charAt(j)) return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return cond;
    }
}