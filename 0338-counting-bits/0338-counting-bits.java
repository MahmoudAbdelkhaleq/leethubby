class Solution {
    public int[] countBits(int n) {
        int[]ans = new int[n+1];
        for(int i =1;i<=n;i++){
            ans[i]=countBinary(i);
        }
        return ans;
    }
    private int countBinary(int n){
        int count = 0;
        while(n>0){
            if(n%2==1) count++;
            n/=2;
        }
        return count;
    }
}