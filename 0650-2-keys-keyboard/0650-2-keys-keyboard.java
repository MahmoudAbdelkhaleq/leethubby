class Solution {
    public int minSteps(int n) {
        int [] dp = new int [n+1];
        for(int i = 2; i< n+1; i++){
            int divisor = gcd(i);
            dp[i] = dp[divisor] + (i/divisor);
        }
        return dp[n];
    }
    public int gcd(int n){
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1;
    }
}