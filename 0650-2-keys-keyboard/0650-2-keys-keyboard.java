class Solution {
    public int minSteps(int n) {
        if(n == 1){
            return 0;
        }
        int divisor = gcd(n);
        return minSteps(divisor) + n/divisor;
    }
    public int gcd(int n){
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                return n/i;
            }
        }
        return 1;
    }
}