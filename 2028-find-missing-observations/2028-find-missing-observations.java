class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int [] res = new int[n];
        int m = rolls.length;
        int sum = mean*(m+n);
        for(int roll:rolls){
            sum-=roll;
        }
        if(n*6<sum || n>sum){
            return new int[0];
        }
        Arrays.fill(res, sum/n);
        for(int i = 0;i<sum%n;i++){
            res[i]++;
        }
        return res;
    }
}