class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int [][] dp = new int [s1.length()+1][s2.length()+1];
        for(int i =0;i<=s1.length();i++){
            dp[i][0] = ASCIISum(s1.substring(0,i));
        }
        for(int i =0;i<=s2.length();i++){
            dp[0][i] = ASCIISum(s2.substring(0,i));
        }
        for(int i = 0;i<s1.length();i++){
            for(int j =0;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }
                else{
                    dp[i+1][j+1] = Math.min((int)s1.charAt(i) + dp[i][j+1], 
                                            (int)s2.charAt(j) + dp[i+1][j]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    private int ASCIISum(String s){
        int x = 0;
        for(int i =0;i<s.length();i++){
            x+=(int)s.charAt(i);
        }
        return x;
    }
}