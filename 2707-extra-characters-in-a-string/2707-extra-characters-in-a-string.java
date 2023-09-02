class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int [] dp = new int [s.length()+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i =1;i<=s.length();i++){
            String current = s.substring(0,i);
            if(contains(dictionary, current)){
                dp[i]=0;
            }
            else {
                for (int j = current.length() - 1; j > -1; j--) {
                    String secondHalf = current.substring(j);
                    if (contains(dictionary, secondHalf)) {
                        dp[i] = Math.min(dp[i], dp[j]);
                    } else {
                        dp[i] = Math.min(dp[i], dp[j] + secondHalf.length());
                    }
                }
            }
        }
        return dp[s.length()];
    }
    private boolean contains(String [] arr, String s){
        for(int i = 0;i<arr.length;i++){
            if(arr[i].equals(s)) return true;
        }
        return false;
    }
}