class Solution {
    public int findJudge(int n, int[][] trust) {
        for(int i =1;i<=n;i++){
            int count = 0;
            boolean trusts = false;
            for(int j =0;j<trust.length;j++){
                if(trust[j][1]==i)count++;
                if(trust[j][0]==i){
                    trusts = true;break;
                }
            }
            if(count == n-1 && !trusts) return i;
        }
        return -1;
    }
}