class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int [] dp = new int [s.length()+1];
        Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i =1;i<=s.length();i++){
            String current = s.substring(0,i);
            if(dictionarySet.contains(current)){
                dp[i]=0;
            }
            else {
                for (int j = current.length() - 1; j > -1; j--) {
                    String secondHalf = current.substring(j);
                    if (dictionarySet.contains(secondHalf)) {
                        dp[i] = Math.min(dp[i], dp[j]);
                    } else {
                        dp[i] = Math.min(dp[i], dp[j] + secondHalf.length());
                    }
                }
            }
        }
        return dp[s.length()];
    }
}