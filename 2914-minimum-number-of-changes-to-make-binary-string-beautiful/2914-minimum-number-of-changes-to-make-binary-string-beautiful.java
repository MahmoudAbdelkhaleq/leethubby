class Solution {
    public int minChanges(String s) {
        int start = 0;
        int changes = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) != s.charAt(start)){
                int length = i-start;
                if(length % 2 != 0){
                    changes++;
                    start = ++i;
                }
                else
                    start = i;
            }
        }
        return changes;
    }
}