class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] check = new boolean[s.length()+1];
        check[0] = true;
        for(int i =0;i<s.length()+1;i++){
            for(int j =0;j<i;j++){
                if(check[j] && wordDict.contains(s.substring(j,i))){
                    check[i] = true;
                    break;
                }
            }
        }
        return check[s.length()];
    }
}